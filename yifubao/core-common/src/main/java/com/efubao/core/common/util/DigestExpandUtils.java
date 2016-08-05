package com.efubao.core.common.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 拓展Apache digesUtils
 */
public class DigestExpandUtils extends DigestUtils{

    private DigestExpandUtils(){}

    /**
     *
     * @param original 原值
     * @param saltKey 盐值
     * @return
     */
    public static String md5Hex(String original, String saltKey){
       String  saltValue = md5Hex(original + saltKey);
       return saltValue;
    }
}
