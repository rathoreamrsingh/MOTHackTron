package com.hackthon.serviceImpl;


import java.util.LinkedList;



import java.util.ArrayList;


import java.util.Queue;
import java.util.concurrent.*;

import org.springframework.stereotype.Component;

import com.hackthon.POJO.QueueServicePOJO;
import com.hackthon.service.QueueService;

@Component
public class QueueServiceImpl  implements QueueService{
	
	private ConcurrentHashMap<String,QueueServicePOJO> queueMap;
	
	public QueueServiceImpl() {
		queueMap = new ConcurrentHashMap<String, QueueServicePOJO>();
		queueMap.put("one", new QueueServicePOJO("one", 10));
	}
	
	
	public int addMessageToQueue(String queueName, String message){
		
		QueueServicePOJO queuePojo = null;
		Queue<String> currentQueue = new LinkedList<String>();
		
		if(queueMap.containsKey(queueName)) {
			queuePojo = queueMap.get(queueName);
			if(queuePojo!=null) {
			currentQueue = queuePojo.getQueue();
			if(queuePojo.getMaxSize() > currentQueue.size()) {
				currentQueue.add(message);
			}else{
				return 1;
				}
			}else {
				return 1;
			}
		}
		return 0;
	}
	
	public int deleteQueue(String queueName) {
		
		if(queueMap.containsKey(queueName)){
			queueMap.remove(queueName);
		}else {
			return 1;
		}
		return 0;
		
	}
	

	public int addQueue(String queueName, int maxSize) {
		QueueServicePOJO  newQueue = new QueueServicePOJO(queueName,maxSize);
		if(queueMap.size()<200) {
			queueMap.put(queueName,newQueue);
		}
		else{
			return 1;
		}
		return 0;
	}
	
	public int removeAll() {
		queueMap.clear();
		return 0;
		
	}


	public ArrayList<String> listQueues(){
		ArrayList<String> qnames = new ArrayList<String>();
		for(String key: queueMap.keySet()) {
			qnames.add(key);
		}
		return qnames;
	}
	
	public Queue<String> browseQueue(String queueName) {
		
			if(!queueMap.containsKey(queueName)) {
				return null;
				
			}
			else {
				return queueMap.get(queueName).getQueue();
			}
		
	}
	 public int removeItemFromQueue(String queueName) {
		
				if(!queueMap.containsKey(queueName)) {
					return 1;
					
				}
				else {
					QueueServicePOJO qsp = queueMap.get(queueName);
					Queue<String> que = qsp.getQueue();
					if(que.isEmpty()) return 1;
					que.remove();
					return 0;
				}
			
	 }
	


}
