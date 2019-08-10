package com.hackthon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackthon.POJO.QueueServicePOJO;
import com.hackthon.service.QueueService;

@RestController
public class QueueController {
	
	@Autowired QueueService service;
	
	@RequestMapping("/addElement")
	public String addElelement(@RequestParam(value="queueName") String queueName,
			@RequestParam(value="message") String message) {
		Integer response =service.addMessageToQueue(queueName, message);
		
		if(response==1) {
			return "failure";
		} else {
			return "success";
		}
		
	}
	
	@RequestMapping("/deleteQueue")
	public String deleteQueue(@RequestParam(value="queueName") String queueName) {
		int response = service.deleteQueue(queueName);
		if(response==1) {
			return "failure";
		} else {
			return "success";
		}
	}

	
	
	
	
	@RequestMapping("/addQueue")
	public String addQueue(@RequestParam(value="queueName") String queueName, @RequestParam(value="maxSize") Integer maxSize) {
		int response = service.addQueue( queueName,  maxSize);
		if(response==1) {
			return "failure";
		} else {
			return "success";
		}
	}
	
	
	@RequestMapping("/removeAll")
	public String removeAll() {
		int response = service.removeAll();
		if(response==1) {
			return "failure";
		} else {
			return "success";
		}
	}
	
	@RequestMapping("/removeItemFromQueue")
	public String removeItemFromQueue(@RequestParam(value="queueName") String queueName) {
		int response = service.removeItemFromQueue(queueName);
		if(response==1) {
			return "failure";
		} else {
			return "success";
		}
	}
	

	
	
	
	
	
	
}
