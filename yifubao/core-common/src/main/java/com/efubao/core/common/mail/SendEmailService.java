/**
 * SendMailService.java
 * Copyright (c) 2013 by lashou.com
 */
package com.efubao.core.common.mail;


import com.efubao.core.common.config.Config;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.File;
import java.util.Map;

/**
 */
@Service
public class SendEmailService {

    static final Logger LOGGER = LoggerFactory
            .getLogger("EMAIL");
    static final String LIVE = "live";
    @Autowired
    private VelocityEngine commonVelocityEngine;
    @Autowired
    private JavaMailSenderImpl commonJavaMailSender;
    @Autowired
    private Config config;

    
    /**
     * 发送邮件
     * @param template 模板
     * @param from 发件人 
     * @param address 收件人
     * @param title 标题
     * @param map 生成模板用数据
     * @param cc 抄送人地址：规则英文,号分隔
     * @return
     */
    public boolean sendEmail(final String template,final String from, final String address, final String title,
            final Map<String, Object> map, final String cc){
    	if(StringUtils.isBlank(address)){
    		return false;
    	}
    	
        final String content = VelocityEngineUtils.mergeTemplateIntoString(commonVelocityEngine, template, "UTF-8", map);
        
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
               MimeMessageHelper message = new MimeMessageHelper(mimeMessage,"UTF-8");
               if (LIVE.equals(config.getEnv())) {
                   message.setTo(address);
               }else{
                   message.setTo(config.getTestEmail());
               }
               this.setFrom(from, address, message);
               if(StringUtils.isNotBlank(cc)) {
	               for(final String c:cc.split(",")){
	                   message.addCc(c);
	               }
               }
               message.setSubject(title);
               message.setText(content, true);
            }

			private void setFrom(final String from, final String address,MimeMessageHelper message) throws MessagingException {
				// 如果收件人邮箱是lashou-inc.com的域名，换成crm@lashou.com
				if (StringUtils.isNotBlank(address) && address.indexOf("@lashou-inc.com") >= 0) {
					message.setFrom("拉手网<crm@lashou.com>");
					return;
				}else{
                    message.setFrom("拉手网<crm@lashou.com>");
                    return;
                }
			}
		};
		
        try {
            commonJavaMailSender.send(preparator);
        }catch(Exception e){
            LOGGER.error(String.format("邮件发送失败,地址:%s",address),e);
            return false;
        }
        return true;
    }
    
    /**
     * 发送邮件smtp
     * @param template 邮件正文模板
     * @param from 发件人
     * @param address 收件人地址 数组
     * @param title 标题
     * @param map 生成模板用数据
     * @param cc 抄送人地址 数组
     * @param bcc 暗送人地址 数组
     * @return
     */
    public boolean sendEmail(final String template,final String from, final String[] address, final String title,
            final Map<String, Object> map, final String[] cc, final String[] bcc) {

        final String content = VelocityEngineUtils.mergeTemplateIntoString(commonVelocityEngine, template, "UTF-8", map);
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
                if (LIVE.equals(config.getEnv())) {
                    message.setTo(address);
                }else{
                    message.setTo(config.getTestEmail());
                }
                setFrom(from, address, message);
                if (cc != null) {
                    message.setCc(cc);
                }
                if (bcc != null) {
                    message.setBcc(bcc);
                }
                message.setSubject(title);
                message.setText(content, true);
            }

            private void setFrom(final String from, final String[] address,MimeMessageHelper message) throws MessagingException {
                String str = StringUtils.join(address, ",");
                // 如果收件人邮箱是lashou-inc.com的域名，换成crm@lashou.com
                if (StringUtils.isNotBlank(str)&& str.indexOf("@lashou-inc.com") >= 0) {
                    message.setFrom("拉手网<crm@lashou.com>");
                    return;
                }else{
                    message.setFrom("拉手网<crm@lashou.com>");
                    return;
                }
            }
        };
        try {
            commonJavaMailSender.send(preparator);
        } catch (Exception e) {
            LOGGER.error(String.format("邮件发送失败,地址:%s", StringUtils.join(address,",")), e);
            return false;
        }
        return true;
    }
    /**
     * 发送邮件smtp
     * @param template 邮件正文模板
     * @param from 发件人
     * @param address 收件人地址 数组
     * @param title 标题
     * @param map 生成模板用数据
     * @param cc 抄送人地址 数组
     * @param bcc 暗送人地址 数组
     * @return
     */
	public boolean sendEmail(final String template, final String from,
			final String[] address, final String title,
			final Map<String, Object> map, final String[] cc,
			final String[] bcc, final Map<String, String> attachement) {
		final String content = VelocityEngineUtils.mergeTemplateIntoString(commonVelocityEngine, template, "UTF-8", map);
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true, "UTF-8");
                if (LIVE.equals(config.getEnv())) {
                    message.setTo(address);
                }else{
                    message.setTo(config.getTestEmail());
                }
				setFrom(from, address, message);
				if (cc != null) {
					message.setCc(cc);
				}
				if (bcc != null) {
					message.setBcc(bcc);
				}
				message.setSubject(title);
				message.setText(content, true);
				for (String key : attachement.keySet()) {
					message.addAttachment(key, new File(attachement.get(key)));
				}
			}

			private void setFrom(final String from, final String[] address,
					MimeMessageHelper message) throws MessagingException {
				String str = StringUtils.join(address, ",");
				// 如果收件人邮箱是lashou-inc.com的域名，换成crm@lashou.com
				if (StringUtils.isNotBlank(str) && str.indexOf("@lashou-inc.com") >= 0) {
					message.setFrom("拉手网<crm@lashou.com>");
					return;
				}else{
                    message.setFrom("拉手网<crm@lashou.com>");
                    return;
                }
			}
		};
        try {
            commonJavaMailSender.send(preparator);
        } catch (Exception e) {
            LOGGER.error(String.format("邮件发送失败,地址:%s", StringUtils.join(address,",")), e);
            return false;
        }
        return true;
	}
    


}
