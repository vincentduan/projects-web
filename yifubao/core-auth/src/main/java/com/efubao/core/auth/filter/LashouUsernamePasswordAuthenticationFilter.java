package com.efubao.core.auth.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.efubao.core.auth.tools.DesEncrypt;
import com.efubao.core.auth.util.AuthUtil;
import com.efubao.core.common.config.Config;
import com.efubao.core.common.util.DigestExpandUtils;
import com.efubao.core.pb.domain.AuthUser;
import com.efubao.core.pb.service.SecurityManageService;

/**
 * 改类主要是对UsernamePasswordAuthenticationFilter进行重写
 * 该Filter主要是将username和password生成token放入到Authentication中
 *
 */
public class LashouUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    /**  */
    @Autowired
    private SecurityManageService securityManageService;

    @Autowired
    private Config config;
    
	static final String LIVE = "live";

	private static final String MSGCODE="msg_code";
    private static final String MOCK_LOGIN = "mock_login";
	
    /* 重写初始化权限 该方法主要是将用户名和密码生成token，放入UserDetail中，以便判断用户的登录态。
     * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter#attemptAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     * @throw AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String checkMsg = request.getParameter("j_checkMsg");
        String userName = request.getParameter("j_username");
        String password = request.getParameter("j_password");
        String scheckMsg = (String) request.getSession().getAttribute(MSGCODE);
        if(StringUtils.isNotBlank(scheckMsg)){
        	request.getSession().setAttribute(MSGCODE, null);
        }
        AuthUser authUser = null;
        String m = (String) request.getSession().getAttribute(MOCK_LOGIN);
        if("1".equals(m)){
        	//mock login
        	authUser = getUserByNameOrPass(userName,password);
        	request.getSession().setAttribute(MOCK_LOGIN,null);
        }else{
	        if (LIVE.equals(config.getEnv())) {
		        if (StringUtils.isBlank(scheckMsg) || !scheckMsg.equalsIgnoreCase(checkMsg)) {
		        	throw new UsernameNotFoundException("短信验证码错误");
		        }
	            if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
	                throw new UsernameNotFoundException("用户或密码不能为空");
	            }
	            String saltPw = getSrcPassWord(password);
	            authUser = securityManageService.findUserByNameAndPw(userName, saltPw);
	    	}else{
				if (StringUtils.isNotBlank(scheckMsg) && !scheckMsg.equalsIgnoreCase(checkMsg)) {
					throw new UsernameNotFoundException("短信验证码错误");
				}
				authUser = getUserByNameOrPass(userName,password);
	    	}
        }
        if (authUser == null) {
            throw new UsernameNotFoundException("用户或密码错误");
        }
        if ("true".equals(request.getParameter(AuthUtil.PARAMETER_REMEMBERME))) {
            request.setAttribute(AuthUtil.PARAMETER_REMEMBERME, true);
        }
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(authUser.getId(),
                "[PROTECTED]");
        super.setDetails(request, authRequest);
        return authRequest;
    }

	private String getSrcPassWord(String password) {
		String srcPW = null;
		try{
			DesEncrypt des = new DesEncrypt();
			srcPW = des.decrypt(password);
		}catch(Exception e){
			logger.error("DES error cause. "+e);
		}
		String saltPw = DigestExpandUtils.md5Hex(srcPW, config.getPasswdSaltKey());
		return saltPw;
	}
    
    /**
     * 测试环境专用
     */
	private AuthUser getUserByNameOrPass(String userName, String password) {
		AuthUser authUser = null;
		if(StringUtils.isNotBlank(password)){
			String saltPw = getSrcPassWord(password);
		    authUser = securityManageService.findUserByNameAndPw(userName, saltPw);
		}else{
			authUser = securityManageService.findUserByName(userName);
		}
		return authUser;
	}
}
