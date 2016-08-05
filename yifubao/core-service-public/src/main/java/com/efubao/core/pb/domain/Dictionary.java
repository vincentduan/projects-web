package com.efubao.core.pb.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 *
 * @author liang
 * @date 2016-03-15
 *
 */
public class Dictionary implements Serializable {
    /** 字典表ID */
    private Long id;

    /**  */
    private String dicKey;

    /**  */
    private String name;

    /**  */
    private String value;

    /** 创建时间 */
    private Timestamp createTime;

    /**  */
    private Timestamp updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDicKey() {
        return dicKey;
    }

    public void setDicKey(String dicKey) {
        this.dicKey = dicKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
}