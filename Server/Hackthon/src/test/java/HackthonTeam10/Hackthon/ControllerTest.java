package HackthonTeam10.Hackthon;

import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.hackthon.controller.QueueController;
import com.hackthon.service.QueueService;

import junit.framework.TestCase;


public class ControllerTest  extends TestCase{
	
	QueueController controller = null;
	
	@Test
	public void addElementTest() throws Exception {
		mock(QueueService.class);
		assertEquals("success", controller.addElelement("vice", "Test"));
        
	}	
		
	@Test
	public void addQueueTest() throws Exception {
		mock(QueueService.class);
		assertEquals("success", controller.addQueue("vice", 200));
        
	}	
       
	@Test
	public void deleteQueueTest() throws Exception {
		mock(QueueService.class);
		assertEquals("success", controller.deleteQueue("vice"));
        
	}	

}
