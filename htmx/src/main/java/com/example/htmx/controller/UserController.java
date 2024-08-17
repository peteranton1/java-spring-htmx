package com.example.htmx.controller;

import com.example.htmx.model.User;
import com.example.htmx.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/users")
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("")
  public String list(Model model) {
    model.addAttribute("users", userRepository.findAll());
    return "users/index";
  }

  @GetMapping("/addUserModal")
  public String addUser() {
    return "users/modal :: modal";
  }

  @GetMapping("/getFakeUser")
  public String getFakeUser(Model model) {
    var user = userRepository.createFakeUser();
    model.addAttribute("user",user);
    return "users/new-user-form :: frmNewUser";
  }

  @PostMapping("")
  public String save(@RequestBody User user, Model model) {
    // add new user
    return "users/new-user-row :: row";
  }

}
