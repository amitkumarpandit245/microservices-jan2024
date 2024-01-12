package com.bvr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class DemoResource {

	public DemoResource() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/servicename")
	public String getServiceName() {
		return "Welcome : Oracle Service";
	}
	
	@GetMapping("/serviceaddress")
	public String getServiceAddress() {
		return "Welcome : Oracle Bangalore";
	}
	
	@GetMapping("/servicedetails")
	public String getServiceDetails() {
		return "Microservices using Feign Client for service invocation";
	}
	
}
