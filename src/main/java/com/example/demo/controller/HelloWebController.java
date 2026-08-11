package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.GreetingService;

@Controller
@RequestMapping("/web")    
public class HelloWebController {
    
    private final GreetingService greetingService;
    
    public HelloWebController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    
    @GetMapping("/hello")  //    http://localhost:8080/web/hello
    public String hello(@RequestParam(defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);  //設定的屬性會傳到html
        model.addAttribute("message", greetingService.greet(name));  //設定的屬性會傳到html
        return "home/hello";  //這是回應給Thymeleaf,會去找home/hello.html 
    }
    
    @GetMapping("/welcome") //    http://localhost:8080/web/welcome 
    public String welcome(Model model) {
        model.addAttribute("message", greetingService.getWelcomeMessage());
        return "home/welcome";
    }
}