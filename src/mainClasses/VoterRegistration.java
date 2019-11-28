package mainClasses;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import Tools.Excel;
import Tools.Utility;
import baseClass.TestCaseConfiguration;
import executionClasses.Exe_VoterRegistration;

public class VoterRegistration extends TestCaseConfiguration {
	
	//Exe_VoterRegistration exe = new Exe_VoterRegistration();
	
	
	@Test
	public void StartExecution() throws Exception{
		
		
		
	//Reports.startTest("Verification of the Voter Registartion");
		new Exe_VoterRegistration().execution();
	//Reports.endTest();
		
	}

}
