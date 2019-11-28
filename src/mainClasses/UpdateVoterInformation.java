package mainClasses;

import org.testng.annotations.Test;

import baseClass.TestCaseConfiguration;
import executionClasses.Exe_UpdateVoterInformation;

public class UpdateVoterInformation extends TestCaseConfiguration {
	
	@Test
	public void UpdateVoterRegistration() throws Exception{
		//Reports.startTest("UpdateVoterInformation");
		new Exe_UpdateVoterInformation().execution();
		//Reports.endTest();
	}

}
