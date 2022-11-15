package com.tm.consumption.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "consumptions")
public class Consumption{
    @Id
    private String id;
    private Integer userId;
    private String beer;
    private Integer count;
    private Integer score;
    private String remark;
    private Date createdAt;

    public Consumption() {
    }

    public Consumption(Integer userId, String beer, Integer count, Integer score, String remark) {
        setUserId(userId);
        setBeer(beer);
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBeer() {
        return beer;
    }

    public void setBeer(String beer) {
        this.beer = beer;
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