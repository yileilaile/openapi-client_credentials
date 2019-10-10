package com.instai.open.model;

/**
 * @author zhaowei 
 * @date   2019/09/25 18:02:21
 * @desc  t_base_auth20_client_details
 */
public class ClientDetailsWithBLOBs extends ClientDetails {
    /**
     * 回调地址：app访问过来的源地址。需要进行校验
     */
    private String redirectUri;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 验证成功跳转资源地址
     */
    private String serviceUrl;

    /**
     * URL白名单(多个用;分割)
     */
    private String urlWhiteList;

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri == null ? null : redirectUri.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl == null ? null : serviceUrl.trim();
    }

    public String getUrlWhiteList() {
        return urlWhiteList;
    }

    public void setUrlWhiteList(String urlWhiteList) {
        this.urlWhiteList = urlWhiteList == null ? null : urlWhiteList.trim();
    }
}