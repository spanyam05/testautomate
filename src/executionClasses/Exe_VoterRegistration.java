package executionClasses;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import Tools.Excel;
import Tools.Utility;
import baseClass.TestCaseConfiguration;

public class Exe_VoterRegistration extends TestCaseConfiguration {
	Tools.Reports r = new Tools.Reports();
	
	String LN;
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

	@FindBy(id = "nm_last")
	WebElement LastName;

	@FindBy(id = "nm_first")
	WebElement FirstName;

	@FindBy(id = "dob_span")
	WebElement DateofBirth;

	@FindBy(xpath = "//select[@class='picker__select--year']")
	WebElement Year;

	@FindBy(xpath = "//select[@class='picker__select--month']")
	WebElement Month;

	@FindBy(xpath = "//div[contains(text(),'11')]")
	WebElement Date;

	/*
	 * @FindBy(xpath =
	 * "//*[@id='dob_span_root']/div/div/div/div/div[2]/button[1]") WebElement
	 * Today;
	 */

	@FindBy(id = "btnSearch")
	WebElement DuplicateSearch;

	@FindBy(xpath = "//h1[@class='card-title']")
	WebElement Assertion1; // It should get Add New Voter Registration

	@FindBy(xpath = "//body[@id='themeContainer']/form[@id='form1']/div[@id='election-wrapper']/div[@id='electio-content-wrapper']/div/div[@class='card']/div[@class='card-body']/div[1]/div[7]/div[1]/input[1]")
	WebElement Partydropdown;

	@FindBy(xpath = "//span[contains(text(),'REPUBLICAN')]")
	WebElement Party;

	@FindBy(xpath = "//div[@class='row']//div[@class='col-6 col-sm-6 col-lg-4 col-xl-3']//input[@class='select-dropdown']")
	WebElement Genderdropdown;

	@FindBy(xpath = "//span[contains(text(),'Male')]")
	WebElement Gender;

	@FindBy(xpath = "//*[@id='electio-content-wrapper']/div[2]/div/div/p[2]/label/span[2]")
	WebElement PreviousNameCheckbox;

	@FindBy(id = "preNmLast")
	WebElement Previouslastname;

	@FindBy(id = "preNmFirst")
	WebElement Previousfirstname;

	@FindBy(id = "preNmMid")
	WebElement Previousmiddlename;

	@FindBy(xpath = "//div[@class='col-12 col-sm-6 col-lg-4 col-xl-2']//input[@class='select-dropdown']")
	WebElement PreviousSuffixdropdown;

	@FindBy(xpath = "//div[@class='col-12 col-sm-6 col-lg-4 col-xl-2']//li[5]")
	WebElement PreviousSuffixdata;

	@FindBy(id = "adNum")
	WebElement RAStreetNumber;

	@FindBy(id = "adStr1")
	WebElement RAStreetNames;

	@FindBy(id = "adCity")
	WebElement RACitys;

	@FindBy(xpath = "//div[@class='col-12 col-sm-6 col-lg-6 col-xl-4']//input[@class='select-dropdown']")
	WebElement RAStatedropdown;

	@FindBy(xpath = "//div[@id='idmap']//li[17]")
	WebElement RAState;

	@FindBy(id = "adZip5")
	WebElement RAZips;

	@FindBy(id = "btnGeocode")
	WebElement SubmitAddress;

	@FindBy(xpath = "/html/body/form/div[2]/div[3]/div[3]/div/div/div[1]/div[2]/table/tbody")
	WebElement Addressclick;

	@FindBy(id = "acceptExtScore")
	WebElement AcceptExistingScore;

	@FindBy(id = "accpetConfirmation")
	WebElement AlertAcceptance;

	@FindBy(xpath = "//*[@id='electio-content-wrapper']/div[2]/div/div/div[10]/div/label/span")
	WebElement InternationalAddress;

	@FindBy(id = "osMailAdStr1")
	WebElement IStreetAddress;

	@FindBy(xpath = "//div[@class='row cvOverseasAddress']//input[@class='select-dropdown']")
	WebElement ICountrydropdown;

	@FindBy(xpath = "//div[@class='row cvOverseasAddress']//li[4]")
	WebElement ICountry;

	@FindBy(id = "osMailDivision")
	WebElement CityCountyPostalCode;

	@FindBy(xpath = "//div[@class='col-12 col-sm-12 col-md-8 col-lg-6 col-xl-4']//input[@class='select-dropdown']")
	WebElement SiteIDdropdown;

	@FindBy(xpath = "//span[contains(text(),'01 - DMV')]")
	WebElement SiteID;
	
	@FindBy(id="idDmv")
	WebElement DrivingLicense;

	@FindBy(xpath = "//label[contains(text(),'The applicant indicated on')]")
	WebElement DriverLicenseCheckbox;

	@FindBy(xpath = "//*[@id='electio-content-wrapper']/div[2]/div/div/div[21]/div/button")
	WebElement Review;
	
	@FindBy(xpath="//*[@id='pills-tabContent']/div[1]/div[1]/div[4]/p")
	WebElement SiteIDinReview;

	@FindBy(xpath = "//*[@id='pills-tabContent']/div[1]/h2")
	WebElement Assertion2;

	@FindBy(xpath = "//*[@id='pills-tabContent']/div[1]/div[1]/div[1]/p")
	WebElement NameinReviewscreen;

	@FindBy(xpath = "//*[@id='pills-tabContent']/div[5]/div/button[2]")
	WebElement SaveButton;

	@FindBy(xpath = "//*[@id='voterSearchResults']/div/div/div[1]/div[2]/p")
	WebElement VID;

	@FindBy(xpath = "//*[@id='voterSearchResults']/div/div/div[4]/div/p")
	WebElement CompletionConfirmation;

	@FindBy(xpath = "//a[contains(text(),'Logout As County')]")
	WebElement LogoutAsCounty;
	
	

	public void execution() throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver.get();
			excelData = Excel.readDataFromExcel("VoterRegistration");

			String dashboard = Dashboard.getText();
			System.out.println(dashboard);

			if (dashboard.equalsIgnoreCase("Dashboard")) {
				Excel.testActualResultsStoring("New voter Registration", 1, "Login to the Application was successfull");
				Excel.testStatusStoring("New voter Registration", 1, "PASS");
			} else {
				Excel.testActualResultsStoring("New voter Registration", 1,
						"Login to the Application was not successfull");
				Excel.testStatusStoring("New voter Registration", 1, "FAIL");
			}

			/*
			 * Utility.isElementPresent(Dashboard,
			 * "Login to the Application was successfull as it displayed Dashboard button after Logging into the Application"
			 * );
			 */
			Ellipses.click();
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
			if(x==0){
				Excel.testActualResultsStoring("New voter Registration", 2,
						"Login to the county was not successfull");
				Excel.testStatusStoring("New voter Registration", 2, "FAIL");
			}
			else{
				Excel.testActualResultsStoring("New voter Registration", 2,
						"Login to the county was successfull");
				Excel.testStatusStoring("New voter Registration", 2, "PASS");
			}
				
			

			js.executeScript("arguments[0].click()", VoterManagement);

			js.executeScript("arguments[0].click()", VoterSearchInformation);

			Utility.explicitlyWait(2000);

			String LN;
			String FN;
			// String DOB = excelData.get("DateofBirth");
			String FullName;

			LN = excelData.get("LastName");
			FN = excelData.get("FirstName");
			FullName = FN.concat(LN);
			System.out.println(FullName);

			LastName.sendKeys(LN);
			FirstName.sendKeys(FN);
			DateofBirth.click();
			Utility.explicitlyWait(1000);
			Select year = new Select(Year);
			year.selectByVisibleText("1980");

			Select month = new Select(Month);
			month.selectByVisibleText("November");
			Date.click();

			// Today.click();

			js.executeScript("arguments[0].click()", DuplicateSearch);

			Utility.explicitlyWait(2000);

			String assertion1 = Assertion1.getText();

			System.out.println(assertion1);

			String assertionexcel = excelData.get("Assertion1");

			if (assertion1.equalsIgnoreCase(assertionexcel)) {
				Excel.testActualResultsStoring("New voter Registration", 3, "Application is displaying the New Voter Registration Page");
				Excel.testStatusStoring("New voter Registration", 3, "PASS");
			} else {
				Excel.testActualResultsStoring("New voter Registration", 3, "Application is not displaying the New Voter Registration Page");
				Excel.testStatusStoring("New voter Registration", 3, "FAIL");
			}

			Partydropdown.click();

			Utility.explicitlyWait(1000);

			Party.click();

			Genderdropdown.click();

			Utility.explicitlyWait(1000);

			Gender.click();

			/*PreviousNameCheckbox.click();

			String PLN = excelData.get("Previous Last Name");
			String PFN = excelData.get("Previous First Name");
			String PMN = excelData.get("Previous Middle Name");

			Previouslastname.sendKeys(PLN);
			Previousfirstname.sendKeys(PFN);
			Previousmiddlename.sendKeys(PMN);

			PreviousSuffixdropdown.click();
			Utility.explicitlyWait(1000);
			PreviousSuffixdata.click();*/

			String RAStreet = excelData.get("StreetNo");
			String RAStreetName = excelData.get("Street Name");
			String RACity = excelData.get("Postal City");
			String RAZip = excelData.get("ZipCode");

			RAStreetNumber.sendKeys(RAStreet);
			RAStreetNames.sendKeys(RAStreetName);
			RACitys.sendKeys(RACity);
			RAStatedropdown.click();
			Utility.explicitlyWait(1000);
			RAState.click();
			RAZips.sendKeys(RAZip);
			SubmitAddress.click();
			Utility.explicitlyWait(3000);
			Addressclick.click();
			Utility.explicitlyWait(3000);
			AcceptExistingScore.click();
			Utility.explicitlyWait(2000);
			AlertAcceptance.click();
			Utility.explicitlyWait(2000);

			/*String IStreetA = excelData.get("StreetAddress");
			String ICity = excelData.get("City");
			String ICounty = excelData.get("County");
			String IZip = excelData.get("ZIpCode");

			InternationalAddress.click();
			IStreetAddress.sendKeys(IStreetA);
			ICountrydropdown.click();
			Utility.explicitlyWait(1000);
			ICountry.click();
			CityCountyPostalCode.sendKeys(ICity);
			CityCountyPostalCode.sendKeys(",");
			CityCountyPostalCode.sendKeys(ICounty);
			CityCountyPostalCode.sendKeys(",");
			CityCountyPostalCode.sendKeys(IZip);*/

			SiteIDdropdown.click();
			Utility.explicitlyWait(1000);
			SiteID.click();
			
			String dmv = excelData.get("Driving License Number");
			
			DrivingLicense.sendKeys(dmv);
			
			
			
			/*DriverLicenseCheckbox.click();*/
			Review.click();
			
			
			Utility.explicitlyWait(2000);
			
			String sid = SiteIDinReview.getText();
			if(sid.equalsIgnoreCase("01 - DMV")){
				Excel.testActualResultsStoring("New voter Registration", 4, "Entered SiteID is displaying correctly in Review screen");
				Excel.testStatusStoring("New voter Registration", 4, "PASS");
			}else{
				Excel.testActualResultsStoring("New voter Registration", 4, "Entered SiteID is not displaying correctly in Review screen");
				Excel.testStatusStoring("New voter Registration", 4, "FAIL");
			}
			String assertion2 = Assertion2.getText();
			String assertionexcel2 = excelData.get("Assertion2");
			String nameinreview = NameinReviewscreen.getText();
			System.out.println(nameinreview);
			if (assertion2.equalsIgnoreCase(assertionexcel2)) {
				
					Excel.testActualResultsStoring("New voter Registration", 5, "Application navigated to the review screen successfully");
					Excel.testStatusStoring("New voter Registration", 5, "PASS");
				
			} else {
				Excel.testActualResultsStoring("New voter Registration", 5, "Application is not navigated to the review screen successfully");
				Excel.testStatusStoring("New voter Registration", 5, "FAIL");
			}

			SaveButton.click();
			Utility.explicitlyWait(2000);
			String completionconfirmation = CompletionConfirmation.getText();
			String completionconfirmationexcel = excelData.get("Confirmation Text");

			if (completionconfirmation.equalsIgnoreCase(completionconfirmationexcel)) {
				Excel.testActualResultsStoring("New voter Registration", 6, "Application completed the Voter Registration successfully");
				Excel.testStatusStoring("New voter Registration", 6, "PASS");

			} else {
				Excel.testActualResultsStoring("New voter Registration", 6, "Application is not able to complete the Voter Registration successfully");
				Excel.testStatusStoring("New voter Registration", 6, "FAIL");
			}

			vRegistrationID = VID.getText();

			

			System.out.println(vRegistrationID);

			r.addPassStep("Verification of the Voter Registration", "Verification of the Voter Registration", "Able to complete the Voter Registration successfully");
			
			Ellipses.click();
			LogoutAsCounty.click();

			Utility.explicitlyWait(2000);
			

		} catch (Exception e) {
			r.addFailStep("Verification of the Voter Registration", "Verification of the Voter Registration", "Unable to complete the Voter Registration successfully");
		}

	}

	public Exe_VoterRegistration() {

		PageFactory.initElements(driver.get(), this);
	}

}
