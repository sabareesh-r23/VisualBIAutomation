package assessments;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import resources.Base;
import utilities.WebData;


public class TestCase1 extends Base {
	 public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test
	void testCase1() throws IOException, InterruptedException {
		log.info("TestCase Started");
		WebData webdata = new WebData();
		webdata.openURL();
		webdata.add_a_TODO();
		webdata.verify_To_do_AreAdded();
		String taskdata [] = {"Drink Water","Get to Work"};
		webdata.make_some_task_completed(taskdata);
		webdata.validateTaskLeft();
		String tobeDeleted []= { "Get to Work" ,"Do some workout"};
		webdata.delete_a_todo(tobeDeleted);
		webdata.validateAfterDeletion();
		webdata.validateTaskLeft();
		webdata.fetchActiveTodoAndValidate();
		webdata.fetchCompletedAndValidate();
		
		
	}
	
	
	@AfterTest void tearDown() { 
		
		driver.quit();
	}
	 
	 
}
