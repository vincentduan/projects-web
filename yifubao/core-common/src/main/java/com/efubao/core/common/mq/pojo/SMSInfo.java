package com.efubao.core.common.mq.pojo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 短信
 *
 */
public class SMSInfo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 3721173232746047497L;
    /**
     * 内容
     */
    private String content;
    /**
     * 收信人
     */
    private String mobile;
    /**
     * 短信类型
     */
    private Integer type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}