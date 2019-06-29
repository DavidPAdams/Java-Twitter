package com.tts.TTTwitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tts.TTTwitter.model.Tweet;
import com.tts.TTTwitter.model.User;
import com.tts.TTTwitter.service.TweetService;
import com.tts.TTTwitter.service.UserService;

@Controller
public class UserController {

   @Autowired
   private UserService userService;
   
   @Autowired
   private TweetService tweetService;
   
   @GetMapping(value = "/users/{username}")
   public String getUser(@PathVariable("username") String username, Model model) {
     User user = userService.findByUsernameContainsIgnoreCase(username);
     List<Tweet> tweets = tweetService.findAllByUser(user);
     model.addAttribute("tweetList", tweets);
     model.addAttribute("user", user);
     return "user";
   }
   
}
