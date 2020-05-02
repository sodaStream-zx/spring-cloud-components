package com.configs.mongodb;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zxx
 * @desc
 * @createTime 2019-08-05-上午 9:47
 */
@ConfigurationProperties(value = "common.mongo")
public class MongoDbPro {
    private Boolean enabled;
    private String uri;
    private String dbName;
    private String collection;

    @Override
    public String toString() {
        return "MongoDbPro{" +
                "enabled=" + enabled +
                ", uri='" + uri + '\'' +
                ", dbName='" + dbName + '\'' +
                ", collection='" + collection + '\'' +
                '}';
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }
}
