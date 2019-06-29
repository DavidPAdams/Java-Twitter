package com.tts.TTTwitter.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Tweet {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "tweet_id")
  private Long id;
  
  private String message;
  
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private User user;
  
  @CreationTimestamp
  private Date createdAt;
  
  public Tweet() {};

  public Tweet(String message, User user, Date createdAt) {
    this.message = message;
    this.user = user;
    this.createdAt = createdAt;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Tweet [id=" + id + ", message=" + message + ", user=" + user + "]";
  }
  
}
