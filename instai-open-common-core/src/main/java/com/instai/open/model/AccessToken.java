package com.instai.open.model;

import java.util.Date;


public class AccessToken {
    /**
     * 
     */
    private Integer id;

    /**
     * Access Token
     */
    private String accessToken;

    /**
     * 接入的客户端ID（appkey）
     */
    private String clientId;

    /**
     * 过期时间戳
     */
    private Long expiresIn;

    /**
     * 授权类型，比如：authorization_code
     */
    private String grantType;

    /**
     * 可被访问的用户的权限范围，比如：basic、super
     */
    private String scope;

    /**
     * 申请人的client_id
     */
    private String createBy;

    /**
     * 申请时间
     */
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType == null ? null : grantType.trim();
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}