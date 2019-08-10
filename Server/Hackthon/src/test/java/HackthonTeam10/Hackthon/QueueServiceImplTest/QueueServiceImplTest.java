package HackthonTeam10.Hackthon.QueueServiceImplTest;

import org.junit.Test;

import com.hackthon.serviceImpl.QueueServiceImpl;

import junit.framework.TestCase;

public class QueueServiceImplTest extends TestCase {
	
	QueueServiceImpl queueService = new QueueServiceImpl();
	

	@Test
	public void testAddQueue() {
		assertEquals(0,queueService.addQueue("test", 10));
	}
	
	@Test
	public void testAddElementToQueue() {
		assertEquals(0,queueService.addMessageToQueue("one", "Hello"));
	}
	
	@Test
	public void testremoveItem() {
		queueService.addMessageToQueue("one", "Hello");
		assertEquals(0,queueService.removeItemFromQueue("one"));
	}
	
	@Test
	public void testListItems() {
		queueService.addMessageToQueue("one", "Hello");
		assertEquals(1,queueService.listQueues().size());
	}
}
