package com.sindhu.promotionmanager.model;

import java.time.LocalDate;

import jakarta.persistence.*;

// This class describes what a promotion is.
@Entity
public class Promotion {
    // Id is primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String store;
    private String couponCode;
    private String description;
    private String category;
    private LocalDate expirationDate;
    private LocalDate savedDate;
    private Boolean used;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Promotion() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getStore() {
        return store;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public LocalDate getSavedDate() {
        return savedDate;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public void setSavedDate(LocalDate savedDate) {
        this.savedDate = savedDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

