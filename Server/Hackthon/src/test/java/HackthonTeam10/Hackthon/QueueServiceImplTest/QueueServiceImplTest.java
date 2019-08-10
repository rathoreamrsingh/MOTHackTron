package HackthonTeam10.Hackthon.QueueServiceImplTest;

import com.hackthon.serviceImpl.QueueServiceImpl;

import junit.framework.TestCase;
import org.junit.Test;

public class QueueServiceImplTest extends TestCase {
	
	QueueServiceImpl queueService = new QueueServiceImpl();
	

	@Test
	public void testAddQueue() {
		assertEquals(0,queueService.addQueue("test", 10));
	}
	
}
