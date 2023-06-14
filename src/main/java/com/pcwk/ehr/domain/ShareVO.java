package com.pcwk.ehr.domain;

import java.util.Date;

public class ShareVO {
    private int seq;
    private Date resultDate;
    private String url;
    private String id;

    public ShareVO(){}

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public Date getResultDate() {
        return resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ShareVO{" +
                "seq=" + seq +
                ", resultDate=" + resultDate +
                ", url='" + url + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
