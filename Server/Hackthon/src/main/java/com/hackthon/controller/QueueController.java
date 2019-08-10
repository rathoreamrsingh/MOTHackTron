package com.hackthon.controller;

import java.util.ArrayList;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackthon.service.QueueService;

@RestController
public class QueueController {
	
	@Autowired QueueService service;
	
	@RequestMapping("/addElement")
	public String addElelement(@RequestParam(value="queueName") String queueName,
			@RequestParam(value="message") String message) {
		Integer response =service.addMessageToQueue(queueName, message);
		
		if(response==1) {
			return "Max queue size reached";
		} else if(response==-1) {
			return "Queue Name not found";
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
	
	@RequestMapping("/listQueues")
	public ArrayList<String> listQueues() {
		ArrayList<String> list = service.listQueues();
		return list;
	}
	
	@RequestMapping("/browseQueue")
	public Queue<String> browseQueue(@RequestParam(value="queueName") String queueName) {
		Queue<String> response = service.browseQueue(queueName);
		return response;
	}
	
	@RequestMapping("/checkFullorEmpty")
	public String checkFullorEmpty(@RequestParam(value="queueName") String queueName) {
		String response = service.checkFullorEmpty(queueName);
		return response;
	}
	
	@RequestMapping("/consume")
	public String consume(@RequestParam(value="queueName") String queueName) {
		String response = service.consume(queueName);
		return response;
	}
	
	
}
