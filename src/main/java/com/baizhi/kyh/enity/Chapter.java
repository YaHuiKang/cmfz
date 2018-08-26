package com.baizhi.kyh.enity;

import java.io.Serializable;
import java.util.Date;

public class Chapter implements Serializable {
    private String id;
    private String title;
    private String url;
    private String size;
    private String length;
    private Integer times;
    private Date createTime;
    private String albumId;

    public Chapter() {
        super();
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", size='" + size + '\'' +
                ", length='" + length + '\'' +
                ", times=" + times +
                ", createTime=" + createTime +
                ", albumId='" + albumId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public Chapter(String id, String title, String url, String size, String length, Integer times, Date createTime, String albumId) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.size = size;
        this.length = length;
        this.times = times;
        this.createTime = createTime;
        this.albumId = albumId;
    }
}
