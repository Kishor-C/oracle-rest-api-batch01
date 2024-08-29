package com.example.swagger_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1") // similar to @Path
public class ProfileController {

	@GetMapping
	public String greet() {
		return "Hello  REST";
	}

	@GetMapping("/abc")
	public String greet2() {
		return "Hello REST Abc";
	}
	
	@PostMapping("/abc")
	public String greet3() {
		return "HELLO REST Post ABC";
	}
	
}
