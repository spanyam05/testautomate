package mainClasses;

import org.testng.annotations.Test;

import baseClass.TestCaseConfiguration;
import executionClasses.Exe_RejectVoterReg;

public class RejectVoterRegistrationFiling extends TestCaseConfiguration {

	@Test
	public void StartExecution() throws Exception{
		//Reports.startTest("RejectVoterRegistration");
		new Exe_RejectVoterReg().execution();
		//Reports.endTest();
	}

}
