package com.example.htmx.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/form")
public class FormController {

  @GetMapping("")
  public String index() {
    return "form/index";
  }

  @PostMapping("/loadUrl")
  public String loadUrl(@RequestParam String url, Model model) {
    log.info("The URL requested: {}", url);
    model.addAttribute("url",url);
    return "form/website :: website";
  }

}
