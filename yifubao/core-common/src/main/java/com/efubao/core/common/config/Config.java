package com.efubao.core.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 */
@Component
public class Config {

    /**
     * 系统密码salt key
     */
    @Value("${t.admin.password.key}")
    private String passwdSaltKey;
    
     //系统模式：test、live
    @Value("${t.env}")
    private String env;

    @Value("${t.test.email}")
    private String testEmail;

    @Value("${t.test.mobile}")
    public String testMbobile;

    @Value("${msg.rabbit.username}")
    public String user;
    @Value("${msg.rabbit.host}")
    public String ip;
    /**
     * 图片服务器域名
     */
    @Value("${img.baseurl}")
    private String imgBaseURL;

    /**生成二维码中使用AES加密用到的key*/
	public String skey = "efubao2015033011";

    public String getPasswdSaltKey() {
        return passwdSaltKey;
    }

    public void setPasswdSaltKey(String passwdSaltKey) {
        this.passwdSaltKey = passwdSaltKey;
    }

	public String getEnv( ) {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

    public String getTestEmail() {
        return testEmail;
    }

    public void setTestEmail(String testEmail) {
        this.testEmail = testEmail;
    }

    public String getTestMbobile() {
        return testMbobile;
    }

    public void setTestMbobile(String testMbobile) {
        this.testMbobile = testMbobile;
    }

	public String getImgBaseURL( ) {
		return imgBaseURL;
	}

	public void setImgBaseURL(String imgBaseURL) {
		this.imgBaseURL = imgBaseURL;
	}

	public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}
}