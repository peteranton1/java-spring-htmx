package com.example.htmx.repository;

import com.example.htmx.model.User;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class UserRepository {

  private final List<User> users = new ArrayList<>();
  private final Faker faker;

  public UserRepository(Faker faker) {
    this.faker = faker;
  }

  public List<User> findAll() {
    return users;
  }

  public User createFakeUser() {
    return new User(faker.name().fullName(), faker.job().title(), faker.internet().emailAddress(), "User");
  }

  @PostConstruct
  private void init() {
    List<User> fakers = List.of(createFakeUser(), createFakeUser(), createFakeUser());
    users.addAll(fakers);
  }

}
