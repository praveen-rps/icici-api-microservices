package com.microservices.security;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	
	@GetMapping("/balance")
	public String balance() {
		return "Account balance is returned";
		
	}
	
	@GetMapping("/details")
	public String details() {
		return "Account details are returned";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "bank address is returned..";
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "user account is deleted..";
	}

}
