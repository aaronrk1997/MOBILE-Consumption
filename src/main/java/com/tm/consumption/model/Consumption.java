package com.tm.consumption.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "consumptions")
public class Consumption{
    @Id
    private String id;
    private String userId;
    private String beerId;
    private Integer count;
    private Integer score;
    private String remark;
    private Date createdAt;

    public Consumption() {
    }

    public Consumption(String userId, String beerId, Integer count, Integer score, String remark) {
        setUserId(userId);
        setBeerId(beerId);
        setCount(count);
        setScore(score);
        setRemark(remark);
        setCreatedAt(new Date());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBeerId() {
        return beerId;
    }

    public void setBeerId(String beerId) {
        this.beerId = beerId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


}