package com.bvr;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class SecondResource {

	public SecondResource() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/message")
	public String test() {
		return " Hello Api Gateway demo - Second Service called";
	}

}
