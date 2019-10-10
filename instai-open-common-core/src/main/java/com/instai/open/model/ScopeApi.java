package com.instai.open.model;
import java.util.Date;

/**
 * @author zhaowei 
 * @date   2019/09/25 18:02:21
 * @desc  t_base_auth20_scope_api
 */
public class ScopeApi {
    /**
     * 
     */
    private Integer id;

    /**
     * 权限范围id
     */
    private Integer scopeId;

    /**
     * 接口id
     */
    private Integer apiId;

    /**
     * 
     */
    private Integer createBy;

    /**
     * 
     */
    private Integer modifyBy;

    /**
     * 
     */
    private Date createDate;

    /**
     * 
     */
    private Date modifyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScopeId() {
        return scopeId;
    }

    public void setScopeId(Integer scopeId) {
        this.scopeId = scopeId;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}