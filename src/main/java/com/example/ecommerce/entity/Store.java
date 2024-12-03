package com.example.ecommerce.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long storeId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String storeName;

    @Column(nullable = false)
    private Date creationDate;

    //getters and setters
    public User getUser(){
        return user;
    }

    public void setUserId(User user){
        this.user = user;
    }

    public long getStoreId(){
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName(){
        return storeName;
    }

    public void setStoreName(String storeName){
        this.storeName = storeName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
