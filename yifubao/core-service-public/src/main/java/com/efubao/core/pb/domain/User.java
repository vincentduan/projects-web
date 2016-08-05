package com.efubao.core.pb.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 *
 * @author zzy
 * @date 2016-03-11
 *
 */
public class User implements Serializable {
    /**  */
    private Long id;

    /** 账号 */
    private String account;

    /** 昵称 */
    private String nickname;

    /** 账号类型:0-用户名;1-电话;2-email */
    private Integer accounttype;

    /** 实名认证状态 */
    private Boolean isRealname;

    /** 电话 */
    private String mobile;

    /** 状态 */
    private Integer status;

    /** 创建时间 */
    private Timestamp createTime;

    /** 更新时间 */
    private Timestamp updateTime;

    /** 是否删除 */
    private Boolean isDel;

    /** 角色:1-大C2-服务商; */
    private Integer role;

    /** 猪八戒用户ID */
    private Long zbjUserId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(Integer accounttype) {
        this.accounttype = accounttype;
    }

    public Boolean getIsRealname() {
        return isRealname;
    }

    public void setIsRealname(Boolean isRealname) {
        this.isRealname = isRealname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Long getZbjUserId() {
        return zbjUserId;
    }

    public void setZbjUserId(Long zbjUserId) {
        this.zbjUserId = zbjUserId;
    }
}