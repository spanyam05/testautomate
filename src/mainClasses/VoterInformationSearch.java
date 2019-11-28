package mainClasses;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Tools.Excel;
import Tools.Utility;
import baseClass.TestCaseConfiguration;
import executionClasses.Exe_VoterInformationSearch;


public class VoterInformationSearch extends TestCaseConfiguration {

	
	@Test
	public void sp(){
		try{
	
		
		
	//	Reports.startTest("Verification of the Voter Search");
		
		exe_SampleProgram().execution();
	
	//	Reports.endTest();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
