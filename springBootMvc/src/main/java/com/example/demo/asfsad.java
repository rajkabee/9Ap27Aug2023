package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class asfsad {
	@RequestMapping("/")
	public String index() {
		return "index.html";
	}
}