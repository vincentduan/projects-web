package com.efubao.core.common.mq.smsenum;

/**
 */
public enum SmsChannelEnum {
    ANXINJIE((short) 1, "安信捷"),
    OTHER((short) 2, "其他");

    private Short id;

    private String desc;

    private SmsChannelEnum(Short id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static SmsChannelEnum getChannelEnum(Short id) {
        if (id == null) {
            return null;
        }
        SmsChannelEnum[] enumArray = SmsChannelEnum.values();
        for (SmsChannelEnum c : enumArray) {
            if (c.id.equals(id)) {
                return c;
            }
        }
        return null;
    }

    public Short getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }
}
