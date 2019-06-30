package com.tts.TTTwitter.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

@Entity
public class Tweet {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "tweet_id")
  private Long id;
  
  @NotEmpty(message = "Tweet cannot be empty")
  @Length(max = 280, message = "Tweet cannot have more than 280 characters")
  private String message;
  
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private User user;
  
  @CreationTimestamp
  private Date createdAt;
  
  @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "tweet_tag", joinColumns = @JoinColumn(name = "tweet_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id"))
  private List<Tag> tags;
  
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

  public List<Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Tweet [id=" + id + ", message=" + message + ", user=" + user + "]";
  }
  
}
