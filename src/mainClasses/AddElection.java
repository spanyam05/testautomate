package mainClasses;

import org.testng.annotations.Test;

import baseClass.TestCaseConfiguration;
import executionClasses.Exe_AddElection;

public class AddElection extends TestCaseConfiguration {
	
	@Test
	public void startExecution() throws Exception{
		
		new Exe_AddElection().execution();
		
	}

}
