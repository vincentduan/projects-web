package com.efubao.core.bigc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.efubao.core.pb.domain.User;
import com.efubao.core.pb.service.UserService;

import com.efubao.core.zbj.dataobject.register.ActiveParamDO;
import com.efubao.core.zbj.dataobject.register.ActiveResultDO;

import com.efubao.core.zbj.dataobject.register.RegisterParamDO;
import com.efubao.core.zbj.dataobject.register.RegisterResultDO;
import com.efubao.core.zbj.dataobject.register.RegisterTypeEnum;
import com.efubao.core.zbj.service.register.UserRegisterZbjService;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/")
public class RegisterController {


	@Autowired
	private UserService userService;
	/*@Autowired
	private UserRegisterZbjService userRegisterZbjDervice;*/

	// 手机验证码
	@RequestMapping(value = "/tosendVerify", method = RequestMethod.GET)
	public String tosendVerif(HttpServletRequest request) {
		return "sendVerify";
	}

	@RequestMapping("/sendVerify")
	public String sendVerify(HttpServletRequest request) {
		// 操作
		// UserRegisterZbjService service = new UserRegisterZbjService();
		try {
			String account = request.getParameter("mobilNum");
			System.out.println("mobilNum:"+account);
			
			int num = (int) (Math.random() * (9999 - 1000 + 1)) + 1000;// 产生1000-9999的随机数
			String nickname = "m_" + Integer.toString(num)
					+ account.substring(8, 11);
			String localip = request.getRemoteAddr();

			RegisterParamDO registerParamDO = new RegisterParamDO();
			registerParamDO.setAccount(account);
			registerParamDO.setNickname(nickname);
			registerParamDO.setIp(localip);
//			registerParamDO.setAccountType(RegisterTypeEnum.MOBILE_QUICK_REG);
			
			UserRegisterZbjService userRegisterZbjDervice = new UserRegisterZbjService();
			RegisterResultDO resultDO = userRegisterZbjDervice.reg(
					registerParamDO, RegisterTypeEnum.MOBILE_QUICK_REG);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";

		
	}

	@RequestMapping(value = "/toRegister", method = RequestMethod.GET)
	public String toRegister(HttpServletRequest request) {
		return "register";
	}

	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
		// 操作
		System.out.println("aaaa");
		// UserRegisterZbjService service = new UserRegisterZbjService();
		try {
			String account = request.getParameter("mobilNum");

			int num = (int) (Math.random() * (9999 - 1000 + 1)) + 1000;// 产生1000-9999的随机数
			String nickname = "m_" + Integer.toString(num)
					+ account.substring(8, 11);
			String password = request.getParameter("verifNum");
			String localip = request.getRemoteAddr();
			String vairlyNum = request.getParameter("checkpassd");
			System.out.print(nickname+password+localip+vairlyNum);

			RegisterParamDO registerParamDO = new RegisterParamDO();
			registerParamDO.setAccount(account);
			registerParamDO.setNickname(nickname);
			registerParamDO.setIp(localip);
			registerParamDO.setPassword(password);
			
			UserRegisterZbjService userRegisterZbjDervice = new UserRegisterZbjService();
			RegisterResultDO resultDO = userRegisterZbjDervice.reg(
					registerParamDO, RegisterTypeEnum.MOBILE_QUICK_REG);

			long verifyId = resultDO.getVerifyId();
			int verifyType = resultDO.getVerifyType();

			String verifyKey = request.getParameter("verifyNum");
			ActiveParamDO activeParamDO = new ActiveParamDO();
			activeParamDO.setIp(localip);
			activeParamDO.setVerifyId((int) verifyId);
			activeParamDO.setVerifyType(verifyType);
			activeParamDO.setVerifyKey(verifyKey);
			ActiveResultDO acRestltDO = userRegisterZbjDervice
					.active(activeParamDO);
			
			long userId = acRestltDO.getUserId();
			String nickName = acRestltDO.getNickname();

			User userInfo = new User();
			userInfo.setAccount(account);
			userInfo.setAccounttype(1);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			userInfo.setCreateTime(Timestamp.valueOf(df.format(new Date())));
			userInfo.setUpdateTime(Timestamp.valueOf(df.format(new Date())));
			userInfo.setNickname(nickName);
			userInfo.setMobile(account);
			userInfo.setIsDel(false);
			userInfo.setRole(1);

			User findUser = userService.findByZbjId(userId);
			if (findUser == null) {

				userService.save(userInfo);
			} else {
				userInfo.setZbjUserId(userId);
				userService.update(userInfo);
			}
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		}
		

	}

}
