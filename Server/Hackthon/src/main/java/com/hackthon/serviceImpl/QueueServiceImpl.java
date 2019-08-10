package com.hackthon.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import com.hackthon.service.QueueService;

public class QueueServiceImpl  implements QueueService{
	
	private Map<String,String> queueMap = new HashMap<String,String>();
	
	public void addQueue(String queueName, String message){
		
		if(queueMap.containsKey(queueName)) {
			
			
			
		}
	}

}
