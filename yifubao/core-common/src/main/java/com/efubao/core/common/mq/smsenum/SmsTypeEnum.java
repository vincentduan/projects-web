package com.efubao.core.common.mq.smsenum;

/**
 */
public enum SmsTypeEnum {
    TEST(0,"测试短信"),
    WEB_IDENTIFYING_CODE(11, "WEB验证码"),
    APP_IDENTIFYING_CODE(12, "APP验证码"),
    MOVIE_TICKETS_SUCCESS(99,"影票取票成功"),
    MOVIE_TICKETS_FAILED(98,"影票取票失败");

    private Integer id;

    private String desc;

    private SmsTypeEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static SmsTypeEnum getTypeEnum(Integer id) {
        if (id == null) {
            return null;
        }
        SmsTypeEnum[] enumArray = SmsTypeEnum.values();
        for (SmsTypeEnum c : enumArray) {
            if (c.id.equals(id)) {
                return c;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }
}