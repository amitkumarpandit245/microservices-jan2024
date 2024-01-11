package com.bvr;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoResource {

	public DemoResource() {
		// TODO Auto-generated constructor stub
	}
	
	Logger Log = LoggerFactory.getLogger(DemoResource.class);
	
	@Autowired
	CircuitBreakerFactory circuitBreakerFactory;
	
	@Autowired
	private HttpBinService httpBin;

	public DemoResource(CircuitBreakerFactory circuitBreakerFactory, HttpBinService httpBin) {
		super();
		this.circuitBreakerFactory = circuitBreakerFactory;
		this.httpBin = httpBin;
	}
	
	@GetMapping("/get")
	public Map get() {
		return httpBin.get();
	}
	
	
	@GetMapping("/delay/{seconds}")
	public Map delay(@PathVariable int seconds) {
		return circuitBreakerFactory.create("delay").run(httpBin.delaySupplier(seconds), t -> {
			Log.warn("delay service call failed error", t);
			
			Map<String, String> fallback = new HashMap<>();
			
			fallback.put("Message_from_fallback_functionality", "Hello Oracle from fallback");
			
			return fallback;
			
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
