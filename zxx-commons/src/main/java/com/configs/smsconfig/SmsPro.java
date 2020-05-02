package com.configs.smsconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zxx
 * @desc
 * @createTime 2019-08-05-上午 10:11
 */
@ConfigurationProperties(value = "common.sms")
public class SmsPro {
    private Boolean enabled;
    //产品名称:云通信短信API产品,开发者无需替换
    private String product;
    //产品域名,开发者无需替换
    private String domain;
    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    private String accessKeyId;
    private String accessKeySecret;
    //签名名称
    private String SIGNNAME;
    //短信模版
    private String SMSTEMPLATE;

    @Override
    public String toString() {
        return "SmsPro{" +
                "enabled=" + enabled +
                ", product='" + product + '\'' +
                ", domain='" + domain + '\'' +
                ", accessKeyId='" + accessKeyId + '\'' +
                ", accessKeySecret='" + accessKeySecret + '\'' +
                ", SIGNNAME='" + SIGNNAME + '\'' +
                ", SMSTEMPLATE='" + SMSTEMPLATE + '\'' +
                '}';
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getSIGNNAME() {
        return SIGNNAME;
    }

    public void setSIGNNAME(String SIGNNAME) {
        this.SIGNNAME = SIGNNAME;
    }

    public String getSMSTEMPLATE() {
        return SMSTEMPLATE;
    }

    public void setSMSTEMPLATE(String SMSTEMPLATE) {
        this.SMSTEMPLATE = SMSTEMPLATE;
    }
}
