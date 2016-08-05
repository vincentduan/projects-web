package com.efubao.core.common.config;

import org.springframework.beans.factory.annotation.Value;

/**
 */

public class BillConfig {

    /** 付款账号 */
    @Value("${t.99bill.payerAcctCode}")
    private String payerAcctCode;

    /** 付款商户名称 */
    @Value("${t.99bill.merchantName}")
    private  String merchantName;

    @Value("${t.99bill.memberCode}")
    private  String memberCode;

    /** 付款人姓名 */
    @Value("${t.99bill.payerName}")
    private String payerName;

    @Value("${t.99bill.url}")
    private String url;

//    @Value("${t.99bill.publicKeyPath}")
    private String publicKeyPath;

//    @Value("${t.99bill.mdfKeyPath}")
    private String mdfKeyPath;

    @Value("${t.99bill.mdfPassWord}")
    private String mdfPassWord;



    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerAcctCode() {
        return payerAcctCode;
    }

    public void setPayerAcctCode(String payerAcctCode) {
        this.payerAcctCode = payerAcctCode;
    }

    public  String getMemberCode() {
        return memberCode;
    }

    public  void setMemberCode(String memberCode) {
        memberCode = memberCode;
    }


    public String getPublicKeyPath() {
        return publicKeyPath;
    }

    public void setPublicKeyPath(String publicKeyPath) {
        this.publicKeyPath = publicKeyPath;
    }

    public String getMdfKeyPath() {
        return mdfKeyPath;
    }

    public void setMdfKeyPath(String mdfKeyPath) {
        this.mdfKeyPath = mdfKeyPath;
    }

    public String getMdfPassWord() {
        return mdfPassWord;
    }

    public void setMdfPassWord(String mdfPassWord) {
        this.mdfPassWord = mdfPassWord;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
