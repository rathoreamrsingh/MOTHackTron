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
	
}
