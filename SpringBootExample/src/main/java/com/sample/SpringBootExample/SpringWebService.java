package com.sample.SpringBootExample;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringWebService {

	@RequestMapping(method = RequestMethod.GET, value = "/health")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String healthCheck(){
		return "Hello";
	}
}
