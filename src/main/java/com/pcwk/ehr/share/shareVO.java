package com.pcwk.ehr.share;

public class shareVO {

    public String Id;

    public String url;

    public String date;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "shareVO{" +
                ", url='" + url + '\'' +
                '}';
    }
}
