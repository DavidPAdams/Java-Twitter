package com.tts.TTTwitter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.TTTwitter.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsernameContainsIgnoreCase(String username);
  List<User> findAllByFirstNameContainsIgnoreCase(String firstName);
  List<User> findAllByLastNameContainsIgnoreCase(String lastName);
//  User findById(Long id)
}
