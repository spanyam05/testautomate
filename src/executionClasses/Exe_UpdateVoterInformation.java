package executionClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Tools.Excel;
import Tools.Utility;
import baseClass.TestCaseConfiguration;

public class Exe_UpdateVoterInformation extends TestCaseConfiguration {

	Tools.Reports r = new Tools.Reports();

	@FindBy(xpath = "//li[@class='breadcrumb-item']")
	WebElement Dashboard;

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

	@FindBy(xpath = "/html[1]/body[1]/div[1]/header[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]")
	WebElement VoterManagement;

	@FindBy(xpath = "//div[@class='dropdown-menu dropdown-default animated fadeIn show']//a[text()='Voter Search Information']")
	WebElement VoterSearchInformation;

	@FindBy(id = "id_voter")
	WebElement VoterID;

	@FindBy(id = "btnSearch")
	WebElement DuplicateSearch;

	@FindBy(xpath = "//*[@id='tableId0']/tbody/tr")
	WebElement VoterResults;

	@FindBy(xpath = "//*[@id='electio-content-wrapper']/div[2]/div/div/div[2]/div/p")
	WebElement ConfirmationVoterID;

	@FindBy(id = "actionBar")
	WebElement ActionBar;

	@FindBy(id = "editVoter")
	WebElement EditVoterDetails;

	@FindBy(id = "dtLastContact_span")
	WebElement ContactDatedatepicker;

	@FindBy(xpath = "//*[@id='dtLastContact_span_root']/div/div/div/div/div[2]/button[1]")
	WebElement ContactDateTodaysDate;

	@FindBy(xpath = "//div[@class='col-12 col-sm-auto col-xl-3']//input[@class='select-dropdown']")
	WebElement SiteIDOrLocationdropdown;

	@FindBy(xpath = "//span[contains(text(),'01 - DMV')]")
	WebElement SiteIDOrLocationOption;

	/*
	 * @FindBy(xpath =
	 * "//div[@class='tab-pane fade show active']//div[@class='col-12 col-sm-6 col-lg-4 col-xl-3']//div[@class='select-wrapper mdb-select md-form']//input[@class='select-dropdown']"
	 * ) WebElement Statusdropdown;
	 * 
	 * @FindBy(xpath = "//span[contains(text(),'Active')]") WebElement
	 * Statusselection;
	 */

	@FindBy(xpath = "//span[contains(text(),'Active')]")
	WebElement ActiveStatus;

	@FindBy(id = "nmMid")
	WebElement MiddleName;

	@FindBy(id = "adNum")
	WebElement RStreetNo;

	@FindBy(id = "adStr1")
	WebElement RStreet1;

	@FindBy(id = "adCity")
	WebElement RCity;

	@FindBy(id = "adZip5")
	WebElement RZip;

	@FindBy(id = "btnGeocode")
	WebElement SubmitAddress;

	@FindBy(id = "streetNumberCheck0")
	WebElement Addresscheck;

	@FindBy(id = "acceptExtScore")
	WebElement ExistingScore;

	@FindBy(xpath = "//div[@class='modal-dialog modal-md modal-dialog-centered custom-modal-md GisModalAlert']//button[@name='acceptBtn'][contains(text(),'ACCEPT')]")
	WebElement Alertacceptance;

	@FindBy(xpath = "//label[contains(text(),'Mailing Address')]")
	WebElement MailingAddress;

	@FindBy(id = "mailAdNum")
	WebElement MStreetNo;

	@FindBy(id = "mailAdStr1")
	WebElement MAddressStreet1;

	@FindBy(id = "mailAdCity")
	WebElement MCity;

	@FindBy(id = "mailAdZip5")
	WebElement MZipCode;

	@FindBy(id = "idDmv")
	WebElement DrivingLicense;

	@FindBy(xpath = "//label[contains(text(),'The applicant indicated on')]")
	WebElement Uncheckcheckbox;

	@FindBy(id = "Continue")
	WebElement ReviewScreen;

	@FindBy(xpath = "//*[@id='pills-tabContent']/div[1]/div[2]/div/p")
	WebElement FullName;

	@FindBy(xpath = "//*[@id='pills-tabContent']/div[1]/h2")
	WebElement ConfirmationTextOnReviewScreen;

	@FindBy(id = "btnAccept")
	WebElement Approve;

	@FindBy(xpath = "//*[@id='voterRegistration']/div[4]/div/p")
	WebElement FinalCompletiontext;

	@FindBy(xpath = "//a[contains(text(),'Logout As County')]")
	WebElement LogoutAsCounty;

	public void execution() throws Exception {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver.get();
			excelData = Excel.readDataFromExcel("ChangeVoterData");

			/*
			 * Utility.isElementPresent(Dashboard,
			 * "Login to the Application was successfull as it displayed Dashboard button after Logging into the Application"
			 * );
			 */
			Ellipses.click();
			/*
			 * Excel.testActualResultsStoring("Change Voter Registration", 1,
			 * "Application completed the Voter Registration successfully");
			 * Excel.testStatusStoring("Change Voter Registration", 1, "PASS");
			 */
			LoginAsCounty.click();

			Utility.explicitlyWait(2000);

			Countydropdown.click();

			Utility.explicitlyWait(1000);

			county.click();

			Loginascountybutton.click();

			// Excel.testResultsStoring("Registration", 1, "PASS");

			Utility.explicitlyWait(2000);

			UserProfile.click();

			Utility.explicitlyWait(1000);

			String cc = Countycheck.getText();

			// System.out.println(cc);

			String[] split = cc.split("\\|");
			int x = 0;

			for (int i = 0; i < split.length; i++) {

				if (split[i].equalsIgnoreCase(" Atkinson")) {
					x++;
				}

			}
			if (x == 0) {
				Excel.testActualResultsStoring("Change Voter Registration", 1,
						"Login to the county was not successfull");
				Excel.testStatusStoring("Change Voter Registration", 1, "FAIL");
			} else {
				Excel.testActualResultsStoring("Change Voter Registration", 1, "Login to the county was successfull");
				Excel.testStatusStoring("Change Voter Registration", 1, "PASS");
			}

			js.executeScript("arguments[0].click()", VoterManagement);

			js.executeScript("arguments[0].click()", VoterSearchInformation);

			Utility.explicitlyWait(2000);

			// String vid = excelData.get("VoterInformation");
			VoterID.sendKeys(vRegistrationID);

			DuplicateSearch.click();

			Utility.explicitlyWait(1000);

			VoterResults.click();

			Utility.explicitlyWait(2000);

			String assertion1 = ConfirmationVoterID.getText();

			// Check Voter Registarion ID Variable to if we run both
			// registartion and Chane voter at the same time.
			if (assertion1.equalsIgnoreCase(vRegistrationID)) {
				System.out.println("PASS");
				// Add a Line regarding the PASS Statement in the Test Case
				// Document.
				Excel.testActualResultsStoring("Change Voter Registration", 2,
						"Application is displaying the Change Voter Registration Page");
				Excel.testStatusStoring("Change Voter Registration", 2, "PASS");
			} else {
				// Add a Line regarding the FAIL Statement in the Test Case
				// Document.
				Excel.testActualResultsStoring("Change Voter Registration", 2,
						"Application is not displaying the Change Voter Registration Page");
				Excel.testStatusStoring("Change Voter Registration", 2, "FAIL");
			}

			js.executeScript("arguments[0].click()", ActionBar);

			EditVoterDetails.click();

			Utility.explicitlyWait(2000);

			ContactDatedatepicker.click();

			Utility.explicitlyWait(1000);

			ContactDateTodaysDate.click();

			Utility.explicitlyWait(2000);

			/*
			 * SiteIDOrLocationdropdown.click();
			 * 
			 * Utility.explicitlyWait(1000);
			 * 
			 * SiteIDOrLocationOption.click();
			 * 
			 * Utility.explicitlyWait(1000);
			 */

			/*
			 * Statusdropdown.click();
			 * 
			 * Utility.explicitlyWait(1000);
			 * 
			 * Statusselection.click();
			 */

			/*
			 * String MN = excelData.get("MiddleName");
			 * 
			 * MiddleName.sendKeys(MN);
			 */
			String rstreetno = excelData.get("RStreetNo");

			RStreetNo.clear();

			RStreetNo.sendKeys(rstreetno);

			RStreet1.clear();

			String rstreet1 = excelData.get("RStreetName");

			RStreet1.sendKeys(rstreet1);

			RCity.clear();

			String rcity = excelData.get("RPostalCity");

			RCity.sendKeys(rcity);

			RZip.clear();

			String rzip = excelData.get("RZipCode");

			RZip.sendKeys(rzip);

			SubmitAddress.click();

			Utility.explicitlyWait(3000);

			Addresscheck.click();

			Utility.explicitlyWait(3000);

			ExistingScore.click();

			Utility.explicitlyWait(2000);

			Alertacceptance.click();

			Utility.explicitlyWait(2000);

			/*
			 * 
			 * MailingAddress.click();
			 * 
			 * Utility.explicitlyWait(1000);
			 * 
			 * String mstreetnumber = excelData.get("MStreetNo");
			 * MStreetNo.sendKeys(mstreetnumber); String maddressline1 =
			 * excelData.get("MAddress1");
			 * MAddressStreet1.sendKeys(maddressline1); String mailingcity =
			 * excelData.get("MailingCity"); MCity.sendKeys(mailingcity); String
			 * mailingxipcode = excelData.get("MailingZipCode");
			 * MZipCode.sendKeys(mailingxipcode);
			 * 
			 * String dmv = excelData.get("DMV");
			 * 
			 * DrivingLicense.sendKeys(dmv);
			 * 
			 * 
			 * 
			 * Uncheckcheckbox.click();
			 */

			ReviewScreen.click();

			Utility.explicitlyWait(1000);

			String fullname = FullName.getText();

			String combo = rstreetno + " " + rstreet1 + "," + " " + rcity + "," + " " + "GA" + " " + rzip;

			if (combo.equalsIgnoreCase(fullname)) {
				Excel.testActualResultsStoring("Change Voter Registration", 3,
						"Application Changed the Residence Address successfully");
				Excel.testStatusStoring("Change Voter Registration", 3, "PASS");
			} else {
				Excel.testActualResultsStoring("Change Voter Registration", 3,
						"Application didn't change the Residence Address successfully");
				Excel.testStatusStoring("Change Voter Registration", 3, "FAIL");
			}

			String confirmationTextOnReviewScreen = ConfirmationTextOnReviewScreen.getText();

			if (confirmationTextOnReviewScreen.equalsIgnoreCase("Voter Registration Review")) {

				Excel.testActualResultsStoring("Change Voter Registration", 4,
						"Application navigated to the Review screen successfully");
				Excel.testStatusStoring("Change Voter Registration", 4, "PASS");

			} else {
				Excel.testActualResultsStoring("Change Voter Registration", 4,
						"Application failed to navigate to the Review screen successfully");
				Excel.testStatusStoring("Change Voter Registration", 4, "FAIL");
			}

			Approve.click();

			String finalCompletiontext = FinalCompletiontext.getText();

			if (finalCompletiontext.equalsIgnoreCase("Voter Registration Completed Successfully")) {
				Excel.testActualResultsStoring("Change Voter Registration", 5,
						"Application completed the Change Voter filing successfully");
				Excel.testStatusStoring("Change Voter Registration", 5, "PASS");
			} else {
				Excel.testActualResultsStoring("Change Voter Registration", 5,
						"Application failed to complete the Change Voter filing successfully");
				Excel.testStatusStoring("Change Voter Registration", 5, "FAIL");
			}
			r.addPassStep("Change of the Voter Registration", "Changing the Address of the Voter",
					"Able to change the Voter details");
			Ellipses.click();
			LogoutAsCounty.click();

			// Reports.log(LogStatus.PASS, "Able to complete the Change Voter
			// Filing successfully.");

		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("Unable to Complete the Change Voter
			// Filing!!");
			// Reports.log(LogStatus.FAIL, "Error Occured while completing the
			// Change Voter Registartion filing");
			r.addFailStep("Change of the Voter Registration", "Changing the Address of the Voter",
					"Unable to change the Voter details");

		}

	}

	public Exe_UpdateVoterInformation() {

		PageFactory.initElements(driver.get(), this);
	}
}
