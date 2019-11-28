package executionClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tools.Excel;
import Tools.Utility;
import baseClass.TestCaseConfiguration;

public class Exe_AddBallot extends TestCaseConfiguration {

	@FindBy(xpath = "//i[@class='fa fa-ellipsis-v desktop-view']")
	WebElement Ellipses;

	@FindBy(xpath = "//a[contains(text(),'Login As County')]")
	WebElement LoginAsCounty;

	@FindBy(xpath = "//input[@class='select-dropdown']")
	WebElement Countydropdown;

	@FindBy(xpath = "//span[contains(text(),'ATKINSON')]")
	WebElement county;

	@FindBy(id = "login")
	WebElement Loginascountybutton;

	@FindBy(id = "userProfile")
	WebElement UserProfile;

	@FindBy(xpath = "//div[@class='dropdown-item disabled']")
	WebElement Countycheck;

	@FindBy(xpath = "//a[@id='header1']")
	WebElement ElectionManagement;

	@FindBy(xpath = "//a[@class='text waves-effect waves-light'][contains(text(),'Ballots')]")
	WebElement Ballots;

	@FindBy(id = "voterid")
	WebElement Vid;

	@FindBy(id = "btnSearch")
	WebElement Search;

	@FindBy(id = "btnVoterInformationSave")
	WebElement Add;

	@FindBy(xpath = "//div[@id='collapse30']//input[@class='select-dropdown']")
	WebElement ElectionDateandName;

	@FindBy(xpath = "/html[1]/body[1]/form[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/ul[1]")
	WebElement Alloptions;

	@FindBy(xpath = "//div[@id='heading31']//i[@class='fa fa-chevron-down float-right black-text']")
	WebElement BallotRequestInformationdropdown;

	@FindBy(xpath = "//label[contains(text(),'Mail Ballot')]")
	WebElement MailBallot;

	@FindBy(xpath = "//div[@id='heading32']//i[@class='fa fa-chevron-down float-right black-text']")
	WebElement BallotIssuedInformationdropdown;

	@FindBy(xpath = "/html/body/form/div[2]/div[3]/div[2]/div/div/div/div/div/div[3]/div[2]/div/div[1]/div[2]/div/span/i")
	WebElement IssuedDate;

	@FindBy(xpath = "/html/body/form/div[2]/div[3]/div[2]/div/div/div/div/div/div[3]/div[2]/div/div[1]/div[2]/div/span/div/div/div/div/div/div[2]/button[1]")
	WebElement TodayDate;

	@FindBy(id = "saveBallotInfo")
	WebElement Save;

	@FindBy(xpath = "//button[@id='reloadPage']")
	WebElement Confirmation;

	@FindBy(xpath = "//td[contains(text(),'12/12/2020')]")
	WebElement ElectionDate;

	@FindBy(xpath = "//fieldset//tbody//tr[1]")
	WebElement BallotRadioButton;

	@FindBy(id = "updateAbsentee")
	WebElement Update;

	public void execution() {

		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		excelData = Excel.readDataFromExcel("AddBallots");

		Ellipses.click();
		LoginAsCounty.click();
		Utility.explicitlyWait(2000);
		Countydropdown.click();
		Utility.explicitlyWait(1000);
		county.click();
		Loginascountybutton.click();
		Utility.explicitlyWait(2000);
		UserProfile.click();

		Utility.explicitlyWait(1000);

		String cc = Countycheck.getText();
		String[] split = cc.split("\\|");
		int x = 0;

		for (int i = 0; i < split.length; i++) {

			if (split[i].equalsIgnoreCase(" Appling")) {
				x++;
			}

		}
		if (x == 0) {
			Excel.testActualResultsStoring("AddBallot", 1, "Login to the county was not successfull");
			Excel.testStatusStoring("AddBallot", 1, "FAIL");
		} else {
			Excel.testActualResultsStoring("AddBallot", 1, "Login to the county was successfull");
			Excel.testStatusStoring("AddBallot", 1, "PASS");
		}
		js.executeScript("arguments[0].click()", ElectionManagement);
		js.executeScript("arguments[0].click()", Ballots);
		Utility.explicitlyWait(2000);
		String id = excelData.get("RegistrationID");
		String election = excelData.get("Election");
		String e[] = election.split("-");
		String e1 = e[0];
		Vid.sendKeys(id);
		Search.click();
		Utility.explicitlyWait(2000);
		Add.click();
		Utility.explicitlyWait(2000);
		ElectionDateandName.click();
		Utility.explicitlyWait(2000);
		WebElement alloptions = Alloptions;
		List<WebElement> elections = alloptions.findElements(By.tagName("li"));
		for (WebElement c : elections) {
			if (c.getText().equalsIgnoreCase(election)) {
				c.click();
				break;
			}
		}
		Utility.explicitlyWait(2000);
		BallotRequestInformationdropdown.click();
		Utility.explicitlyWait(1000);
		MailBallot.click();
		BallotIssuedInformationdropdown.click();
		Utility.explicitlyWait(2000);
		IssuedDate.click();
		Utility.explicitlyWait(2000);
		TodayDate.click();
		Utility.explicitlyWait(1000);
		Save.click();
		Utility.explicitlyWait(1000);
		Confirmation.click();
		Utility.explicitlyWait(2000);
		String electiondate = ElectionDate.getText();
		if (electiondate.equalsIgnoreCase(e1)) {
			System.out.println("PASS");
		}
		Utility.explicitlyWait(2000);
		BallotRadioButton.click();

	}

	public Exe_AddBallot() {
		PageFactory.initElements(driver.get(), this);
	}

}
