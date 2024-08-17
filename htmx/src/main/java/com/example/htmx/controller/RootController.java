package com.example.htmx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class RootController {
  @GetMapping("")
  public String index() {
    return "root/index";
  }

  @GetMapping("/banner")
  public String banner(Model model) {
    model.addAttribute("title", "Java Spring Htmx 2024");
    model.addAttribute("message","A demo application using java, spring, thymeleaf, htmx");
    return "root/banner :: banner";
  }
}
