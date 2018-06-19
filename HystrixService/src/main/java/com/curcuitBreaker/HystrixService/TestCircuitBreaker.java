package com.curcuitBreaker.HystrixService;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestCircuitBreaker {

	
	  @RequestMapping("/getEmployee/{empId}")
	  @Produces({MediaType.APPLICATION_JSON})
	  @HystrixCommand(fallbackMethod = "getDataFallBack")
	  public Employee getEmployee( @PathVariable String empId){
		  System.out.println("getEmployee");
		  Employee emp = new Employee();
		  emp.setEmpId(empId);
		  emp.setName("Vinit");
		  emp.setSalary(1000000);
		  emp.setDesignation("Private");
		  
		  if (empId.endsWith("junk"))
			  throw new RuntimeException("Exception");
		  return emp;
	  }
	  
	  public Employee getDataFallBack( @PathVariable String empId){
		  System.out.println("getDataFallBack");
		  Employee emp = new Employee();
		  emp.setEmpId(empId);
		  emp.setName("Junk");
		  emp.setSalary(1000000);
		  emp.setDesignation("N/A");
		  return emp;
	  }
}
