package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Book;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/attribute")
public class AttributeController {
    
	@GetMapping("/img")  //    http://localhost:8080/attribute/img
	public String imageAttr(Model model) {
		String[] imgs= {"banana.png","grape.png","guava.png","orange.png"};
		int index=(int)(Math.random()*imgs.length);
		model.addAttribute("fruitImage", imgs[index]);
		return "showimage";
	}
	
	
	
	
	@GetMapping("/status")   //   http://localhost:8080/attribute/status
	public String statusAttr(Model model) {
		model.addAttribute("isLogin", "false");  //傳回false
		return "status";
	}
	
	
	
	
	@GetMapping("/role")     //    http://localhost:8080/attribute/role
	public String roleAttr(Model model) {
		int v=(int)(Math.random()*3)+1;
		model.addAttribute("role", v==1 ? "admin":(v==2 ? "user":"NA"));
		return "role";
	}
	
	
	
	
	@GetMapping("/for")  // http://localhost:8080/attribute/for
	public String forAttr(Model model) {
	    // 建立書籍清單
	    List<Book> books = Arrays.asList(
	        new Book(1, "book1", 100),
	        new Book(2, "book2", 200)
	    );
	    
	    // 加入 Model
	    model.addAttribute("title", "書籍列表");
	    model.addAttribute("users", books);  // 注意：這裡叫 users，但實際是 books
	    
	    return "for";
	}
	
	
	
	
	@GetMapping("/session")  //http://localhost:8080/attribute/session
	public String sessionAttr(Model model,HttpSession session) {
		session.setAttribute("user", "John Lee");  //需人工setAttribute
		model.addAttribute("price", 19.9565);
		model.addAttribute("today", new java.util.Date());
		return "session";
	}
	
	
	
	
	@GetMapping("/href")  //    http://localhost:8080/attribute/href
	public String hrefAttr(Model model) {
		
		model.addAttribute("userId", 100);
		return "hyperlink";
	}
	
	
	
}
