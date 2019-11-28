package mainClasses;

import org.testng.annotations.Test;

import baseClass.TestCaseConfiguration;
import executionClasses.Exe_TransferVoterRegistration;

public class TransferVoterRegistration extends TestCaseConfiguration {
	
	@Test
	public void startExecution() throws Exception{
		//Reports.startTest("Trasfer Voter Registration");
		new Exe_TransferVoterRegistration().execution();
		//Reports.endTest();
	}
	
	

}
