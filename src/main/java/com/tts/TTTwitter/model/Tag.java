package com.tts.TTTwitter.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  private String phrase;
  
  @ManyToMany(mappedBy = "tags")
  private List<Tweet> tweets;
  
  public Tag() {};

  public Tag(String phrase) {
    this.phrase = phrase;
  }

  public String getPhrase() {
    return phrase;
  }

  public void setPhrase(String phrase) {
    this.phrase = phrase;
  }

  public Long getId() {
    return id;
  }

}
