package com.curcuitBreaker.HystrixService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableCircuitBreaker
public class HysrtrixAppllcation {

	 public static void main(String[] args) {
	        SpringApplication.run(HysrtrixAppllcation.class, args);
	    }
	}

	@RestController
	class ServiceInstanceRestController {

	    

	    @RequestMapping("/service-instances/{applicationName}")
	    public String serviceInstancesByApplicationName(
	            @PathVariable String applicationName) {
	        return applicationName;
	    }
}
