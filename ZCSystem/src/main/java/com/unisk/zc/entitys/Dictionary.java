package com.unisk.zc.entitys;

import java.util.Date;

public class Dictionary extends BaseQuery<Dictionary>{
    private Integer id;

    private String kinds;

    private String ukey;

    private String uvalue;

    private String umaxvalue;

    private String uminvalue;

    private String remarks;

    private Byte delmark;

    private Date createtime;

    private Integer createuserid;

    private Date modifytime;

    private Integer modifyuserid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds == null ? null : kinds.trim();
    }

    public String getUkey() {
        return ukey;
    }

    public void setUkey(String ukey) {
        this.ukey = ukey == null ? null : ukey.trim();
    }

    public String getUvalue() {
        return uvalue;
    }

    public void setUvalue(String uvalue) {
        this.uvalue = uvalue == null ? null : uvalue.trim();
    }

    public String getUmaxvalue() {
        return umaxvalue;
    }

    public void setUmaxvalue(String umaxvalue) {
        this.umaxvalue = umaxvalue == null ? null : umaxvalue.trim();
    }

    public String getUminvalue() {
        return uminvalue;
    }

    public void setUminvalue(String uminvalue) {
        this.uminvalue = uminvalue == null ? null : uminvalue.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Byte getDelmark() {
        return delmark;
    }

    public void setDelmark(Byte delmark) {
        this.delmark = delmark;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(Integer createuserid) {
        this.createuserid = createuserid;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Integer getModifyuserid() {
        return modifyuserid;
    }

    public void setModifyuserid(Integer modifyuserid) {
        this.modifyuserid = modifyuserid;
    }
}