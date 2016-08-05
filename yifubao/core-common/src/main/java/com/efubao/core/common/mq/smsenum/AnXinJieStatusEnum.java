package com.efubao.core.common.mq.smsenum;

/**
 */
public enum AnXinJieStatusEnum {
    SUCCESS("00", "提交成功"),
    PARAM_EXCEPTION("01", "提交参数异常，参数不完整"),
    MOBILES_EXCEPTION("02", "手机号参数异常"),
    SUBID_EXCEPTION("03", "扩展号参数异常"),
    SENDTIME_EXCEPTION("04", "发送时间参数异常"),
    CONTENT_EXCEPTION("05", "短信内容解析异常，长短信处理异常"),
    IP_ACCESS_EXCEPTION("10", "IP认证失败"),
    ACOUNT_EXCEPTION("11", "帐户认证失败"),
    SUBID_LENGTH_EXCEPTION("12", "扩展号长度异常"),
    MOBILE_WHITELIST_EXCEPTION("13", "手机号异常，特指黑白名单"),
    PROHIBITED_WORDS_EXCEPTION("14", "违禁词异常"),
    ACOUNT_NOTENOUGH_MONEY_EXCEPTION("15", "帐户余额不足"),
    DAYLYLIMIT_EXCEPTION("16", "单日条数限制"),
    CONTENT_CHECKOUT_EXCEPTION("17", "信息检查失败"),
    DAYLYLIMIT_PERMOBILE_EXCEPTION("18", "同一手机号，当日发送条数过多"),
    SAVE_DATA_EXCEPTION("20", "保存数据异常，特指发送保存信息失败");

    private String value;

    private String desc;

    private AnXinJieStatusEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static AnXinJieStatusEnum getStatusEnum(String value) {
        if (value == null) {
            return null;
        }
        AnXinJieStatusEnum[] enumArray = AnXinJieStatusEnum.values();
        for (AnXinJieStatusEnum c : enumArray) {
            if (c.value.equals(value)) {
                return c;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}