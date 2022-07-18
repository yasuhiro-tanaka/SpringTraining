package com.example.demo.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.app.inquiry.InquiryForm;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@PostMapping()
	public String login(Model model) {
		return "redirect:/inquiry";
	}
}
