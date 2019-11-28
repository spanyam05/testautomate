package mainClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseClass.TestCaseConfiguration;

public class TestReferenceSample extends TestCaseConfiguration {
	
	Tools.Reports r = new Tools.Reports();
	
	
	
	
	
	
	
    @Test
	public void methodAction() throws Exception{
	r.addPassStep("Test", "T", "T");
	r.mailGeneration("itsdragonfly7@gmail.com", "kamisettyyashwanth@gmail.com", "Test", "Aslan4455");
	}

}
	