package com.baizhi.kyh.enity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Album implements Serializable {
    private String id;
    private String title;
    private Double score;
    private String brodercast;
    private String author;
    private String description;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishTime;
    private Integer count;
    private String  coverImg;
    private Integer status;
    private List<Chapter> children;
    public Album() {
        super();
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", score=" + score +
                ", brodercast='" + brodercast + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", publishTime=" + publishTime +
                ", count=" + count +
                ", coverImg='" + coverImg + '\'' +
                ", status=" + status +
                ", children=" + children +
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getBrodercast() {
        return brodercast;
    }

    public void setBrodercast(String brodercast) {
        this.brodercast = brodercast;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    public Album(String id, String title, Double score, String brodercast, String author, String description, Date publishTime, Integer count, String coverImg, Integer status, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.score = score;
        this.brodercast = brodercast;
        this.author = author;
        this.description = description;
        this.publishTime = publishTime;
        this.count = count;
        this.coverImg = coverImg;
        this.status = status;
        this.children = children;
    }
}
