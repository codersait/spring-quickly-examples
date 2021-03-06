package com.example.gswsch7ex4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @GetMapping("/home")
  public String home(
      @RequestParam(required = false) String color,
      Model page) {
    page.addAttribute("username", "Katy");
    page.addAttribute("color", color);
    return "home.html";
  }

  @PostMapping("/home")
  public String postHome(
      @RequestParam(required = false) String color,
      @RequestParam(required = false) String name,
      Model page) {
    page.addAttribute("username", name);
    page.addAttribute("color", color);
    return "home.html";
  }
}
