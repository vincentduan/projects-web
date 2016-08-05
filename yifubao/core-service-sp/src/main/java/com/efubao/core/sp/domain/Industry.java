package com.efubao.core.sp.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import com.efubao.core.common.base.BasePo;

/**
 * 
 *
 * @author zzy
 * @date 2016-03-09
 *
 */
public class Industry extends BasePo implements Serializable {
    /**  */
    private Long id;

    /** 名称 */
    private String name;

    /** 排序 */
    private Integer sort;

    /** 创建时间 */
    private Timestamp createTime;

    /** 更新时间 */
    private Timestamp updateTime;

    /** 是否删除 */
    private Boolean isDel;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
}