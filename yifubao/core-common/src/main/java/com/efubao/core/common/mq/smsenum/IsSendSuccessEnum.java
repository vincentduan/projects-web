package com.efubao.core.common.mq.smsenum;
/**
 */
public enum IsSendSuccessEnum {
    SEND_SUCCESS(true, "发送成功"),
    SEND_FAILED(false, "发送失败");

    private Boolean status;

    private String desc;

    private IsSendSuccessEnum(Boolean status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static IsSendSuccessEnum getIsSendSuccessEnum(Integer id) {
        if (id == null) {
            return null;
        }
        IsSendSuccessEnum[] enumArray = IsSendSuccessEnum.values();
        for (IsSendSuccessEnum c : enumArray) {
            if (c.status.equals(id)) {
                return c;
            }
        }
        return null;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}