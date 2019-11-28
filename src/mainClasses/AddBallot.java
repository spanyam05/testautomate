package mainClasses;

import org.testng.annotations.Test;

import baseClass.TestCaseConfiguration;
import executionClasses.Exe_AddBallot;

public class AddBallot extends TestCaseConfiguration{
	
@Test
public void startExecution(){
	new Exe_AddBallot().execution();
}

}
