package com.bvr.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bvr.models.PropertyAccessBean;
import com.bvr.models.PropertyAccessValue;

@RestController
@RequestMapping("/access")
public class PropertyFileAccessResource {

	public PropertyFileAccessResource() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	PropertyAccessBean propertyAccessBean;
	
	@GetMapping("accessPropertyFile")
	public PropertyAccessValue accessPropertyFile() {
		return new PropertyAccessValue(propertyAccessBean.getName(), propertyAccessBean.getDescription());
		
	}
}
