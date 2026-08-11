package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller   //若前端是Thymeleaf,需指定@Controller使用Thymeleaf
@RequestMapping("/thymeleaf")   //   http://localhost:8080/thymeleaf
public class ThymeleafController {
	
	  @GetMapping
      public String firstThymeleaf(Model model) {  //Model是一個承載資料的容器（介面）用來把後端的Java資料傳遞給前端的網頁模板（如 index.html）
          model.addAttribute("greeting", "Good Morning");  
          //底層運作時是一個Java的Map<String, Object>。 => model.addAttribute("greeting", "Good Morning"); => 在概念上等同於：javaMap.put("greeting", "Good Morning");
          model.addAttribute("htmlContent", "<h1 style='color:blue'>Good Morning</h1>"); //需對應到前端的key => "htmlContent"
    	  return "index"; // 指的是index.html檔案,不需輸入副檔名
      }
}
