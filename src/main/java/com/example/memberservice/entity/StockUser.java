package com.example.memberservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="stock_user", catalog = "test")
public class StockUser {

    public StockUser() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_user_seq")
    @SequenceGenerator(sequenceName = "stock_user_seq", allocationSize = 1, name = "stock_user_seq")
    private Integer id;

    @Column(name= "user_id")
    private String userId;

    @Column(name= "stock")
    private Integer stock;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getStock() {
        return stock;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
