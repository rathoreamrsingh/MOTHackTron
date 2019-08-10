package com.hackthon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackthon.service.QueueService;

@RestController
public class QueueController {
	
	@Autowired QueueService service;
	
	@RequestMapping("/addElement")
	public String addElelement(@RequestParam(value="name") String name,
			@RequestParam(value="message") String message) {
		String response =service.addMessageToQueue(name, message);
		
	return response;
	}

	
	
	
}
