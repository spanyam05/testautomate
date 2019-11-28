package executionClasses;

import org.openqa.selenium.JavascriptExecutor;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Tools.Excel;
import Tools.Utility;
import baseClass.TestCaseConfiguration;

public class Exe_VoterInformationSearch extends TestCaseConfiguration {

	Tools.Reports r = new Tools.Reports();

	String status;
	String LastName;
	String FirstName;
	String DateofBirth;
	String Vid;
	String LN;
	String FN;

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

	@FindBy(xpath = "/html[1]/body[1]/div[1]/header[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]")
	WebElement VoterManagement;

	@FindBy(xpath = "//div[@class='dropdown-menu dropdown-default animated fadeIn show']//a[text()='Voter Search Information']")
	WebElement VoterSearchInformation;

	@FindBy(xpath = "//a[contains(text(),'View Voter Information')]")
	WebElement ViewVoterInformation;

	@FindBy(id = "voterid")
	WebElement VoterID;

	@FindBy(id = "btnSearch1")
	WebElement SearchbuttoninViewVoterInformationscreen;

	@FindBy(xpath = "//*[@id='electio-content-wrapper']/div[2]/div/h1")
	WebElement VoterSearchInformationPage;

	@FindBy(xpath = "//*[@id='tableId0']/tbody/tr/td[10]")
	WebElement ResidenceAddress;

	@FindBy(xpath = "//td[contains(text(),'PENDING VERIFICATION')]")
	WebElement VStatus;

	@FindBy(xpath = "/html[1]/body[1]/form[1]/div[2]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")
	WebElement VLN;

	@FindBy(xpath = "/html[1]/body[1]/form[1]/div[2]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]")
	WebElement VFN;

	@FindBy(xpath = "//*[@id='tableId0']/tbody/tr/td[7]")
	WebElement VDOB;

	@FindBy(xpath = "//*[@id='tableId0']/tbody/tr/td[11]")
	WebElement countyinreview;

	@Test
	public void execution() throws Exception {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver.get();
			excelData = Excel.readDataFromExcel("VoterRegistration");

			Ellipses.click();
			LoginAsCounty.click();

			Utility.explicitlyWait(2000);

			Countydropdown.click();

			Utility.explicitlyWait(1000);

			county.click();

			Loginascountybutton.click();

			Utility.explicitlyWait(2000);

			js.executeScript("arguments[0].click()", VoterManagement);

			js.executeScript("arguments[0].click()", VoterSearchInformation);

			js.executeScript("arguments[0].click()", ViewVoterInformation);

			Utility.explicitlyWait(2000);

			// Vid = excelData.get("VRegNumber");

			VoterID.sendKeys(vRegistrationID);

			js.executeScript("arguments[0].click()", SearchbuttoninViewVoterInformationscreen);

			String voterSearchInformationPage = VoterSearchInformationPage.getText();
			if (voterSearchInformationPage.equalsIgnoreCase("View Voter Information")) {
				Excel.testActualResultsStoring("Voter Search", 1,
						"Application navigated to the View Voter Information screen");
				Excel.testStatusStoring("Voter Search", 1, "PASS");
			} else {
				Excel.testActualResultsStoring("Voter Search", 1,
						"Application is not navigated to the View Voter Information screen");
				Excel.testStatusStoring("Voter Search", 1, "FAIL");
			}

			LastName = VLN.getText();

			FirstName = VFN.getText();

			//DateofBirth = VDOB.getText();

			String countyinre = countyinreview.getText();

			if (countyinre.equalsIgnoreCase("ATKINSON")) {
				Excel.testActualResultsStoring("Voter Search", 2,
						"Application is displaying the correct Residence Address details");
				Excel.testStatusStoring("Voter Search", 2, "PASS");
			} else {
				Excel.testActualResultsStoring("Voter Search", 2,
						"Application is displaying the wrong Residence Address details");
				Excel.testStatusStoring("Voter Search", 2, "FAIL");
			}

			// validation();
			
			LN = excelData.get("LastName");
			FN = excelData.get("FirstName");

			if (((LastName.equalsIgnoreCase(LN)) && (FirstName.equalsIgnoreCase(FN)))) {
				r.addPassStep("Verification of the Voter details", "Verification of the Voter details",
						"Application is displaying the correct voter details.");

			} else {
				// Reports.log(LogStatus.FAIL, "Displayed details are not for:"
				// + Vid);
				r.addFailStep("Verification of the Voter details", "Verification of the Voter details",
						"Application is displaying the in-correct voter details.");
				// return false;

			}

		} catch (Exception e) {
			r.addFailStep("Verification of the Voter details", "Verification of the Voter details",
					"Application is displaying the in-correct voter details.");
		}

	}

	/*
	 * public void validation() throws Exception {
	 * 
	 * }
	 */

	public Exe_VoterInformationSearch() {
		PageFactory.initElements(driver.get(), this);
	}

}
