package com.bvr.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bvr.util.FeignServiceUtil;

@RestController
@RequestMapping("/feigndemo")
public class FeignResource {

	public FeignResource() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	FeignServiceUtil feignServiceUtil;
	
	@GetMapping("/customer-servicename")
	public String getCustomerServiceName() {
		return feignServiceUtil.getServiceName();
	}

	@GetMapping("/customer-serviceaddress")
	public String getCustomerServiceAddress() {
		return feignServiceUtil.getServiceAddress();
	}

	
	@GetMapping("/customer-servicedetails")
	public String getCustomerServiceDetails() {
		return feignServiceUtil.getServiceDetails();
	}

}
