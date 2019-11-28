package executionClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Tools.Excel;
import Tools.Utility;
import baseClass.TestCaseConfiguration;

public class Exe_RejectVoterReg extends TestCaseConfiguration {
	
	Tools.Reports r = new Tools.Reports();
	
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
	
	@FindBy(xpath="//button[@class='picker__button--today']")
	WebElement TodaysDate;

	@FindBy(id = "btnSearch")
	WebElement DuplicateSearch;
	
	@FindBy(xpath = "//h1[@class='card-title']")
	WebElement ConfirmationText;
	
	@FindBy(xpath = "//body[@id='themeContainer']/form[@id='form1']/div[@id='election-wrapper']/div[@id='electio-content-wrapper']/div/div[@class='card']/div[@class='card-body']/div[1]/div[7]/div[1]/input[1]")
	WebElement Partydropdown;

	@FindBy(xpath = "//span[contains(text(),'REPUBLICAN')]")
	WebElement Party;

	@FindBy(xpath = "//div[@class='row']//div[@class='col-6 col-sm-6 col-lg-4 col-xl-3']//input[@class='select-dropdown']")
	WebElement Genderdropdown;

	@FindBy(xpath = "//span[contains(text(),'Male')]")
	WebElement Gender;
	
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
	
	@FindBy(xpath="//*[@id='electio-content-wrapper']/div[2]/div/div/div[8]/div[5]/div/div/div/p")
	WebElement AddressConfirmation;
	
	@FindBy(xpath = "//div[@class='col-12 col-sm-12 col-md-8 col-lg-6 col-xl-4']//input[@class='select-dropdown']")
	WebElement SiteIDdropdown;

	@FindBy(xpath = "//span[contains(text(),'01 - DMV')]")
	WebElement SiteID;
	
	@FindBy(id="idDmv")
	WebElement DrivingLicense;
	
	@FindBy(xpath = "//*[@id='electio-content-wrapper']/div[2]/div/div/div[21]/div/button")
	WebElement Review;
	
	@FindBy(xpath="//*[@id='electio-content-wrapper']/div[2]/div/h1")
	WebElement RejectionReasonText;
	
	@FindBy(xpath="//input[@class='select-dropdown']")
	WebElement RejectionReasondropdown;
	
	@FindBy(xpath="//span[contains(text(),'Under Age')]")
	WebElement RejectionReason;
	
	@FindBy(id="btnReject")
	WebElement Reject;
	
	@FindBy(xpath="//*[@id='electio-content-wrapper']/div[2]/div/div/div/div")
	WebElement RejectionConfirmation;
	
	@FindBy(xpath = "//a[contains(text(),'Logout As County')]")
	WebElement LogoutAsCounty;
	
	public void execution() throws Exception{
		try{
		
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		excelData = Excel.readDataFromExcel("RejectVoterRegistration");
		
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
			
			if (split[i].equalsIgnoreCase(" Atkinson")) {
				x++;
			} 
			
			}
		if(x==0){
			Excel.testActualResultsStoring("New Voter Rejection", 1,
					"Login to the county was not successfull");
			Excel.testStatusStoring("New Voter Rejection", 1, "FAIL");
		}
		else{
			Excel.testActualResultsStoring("New Voter Rejection", 1,
					"Login to the county was successfull");
			Excel.testStatusStoring("New Voter Rejection", 1, "PASS");
		}
			
		

		js.executeScript("arguments[0].click()", VoterManagement);

		js.executeScript("arguments[0].click()", VoterSearchInformation);

		Utility.explicitlyWait(2000);
		
		String LN;
		String FN;
		
		LN = excelData.get("LastName");
		FN = excelData.get("FirstName");
		
		LastName.sendKeys(LN);
		FirstName.sendKeys(FN);
		
		DateofBirth.click();
		
		Utility.explicitlyWait(1000);
		
		TodaysDate.click();
		
		js.executeScript("arguments[0].click()", DuplicateSearch);
		
		Utility.explicitlyWait(2000);
		
		String confirmationText = ConfirmationText.getText();
		
		if(confirmationText.equalsIgnoreCase("Add New Voter Registration")){
			Excel.testActualResultsStoring("New Voter Rejection", 2,
					"Navigated to the New Voter Registration page successfully");
			Excel.testStatusStoring("New Voter Rejection", 2, "PASS");
		}else{
			Excel.testActualResultsStoring("New Voter Rejection", 2,
					"Not able to Navigate to the New Voter Registration page successfully");
			Excel.testStatusStoring("New Voter Rejection", 2, "FAIL");
		}
		
		Partydropdown.click();

		Utility.explicitlyWait(1000);

		Party.click();

		Genderdropdown.click();

		Utility.explicitlyWait(1000);

		Gender.click();

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
		
		
		
		SiteIDdropdown.click();
		Utility.explicitlyWait(1000);
		SiteID.click();
		
		String dmv = excelData.get("Driving License Number");
		
		DrivingLicense.sendKeys(dmv);
		
        String AC = AddressConfirmation.getText();
		
		if(AC.equalsIgnoreCase("786 AUSTIN AVENUE EAST PEARSON GA 31642")){
			Excel.testActualResultsStoring("New Voter Rejection", 3,
					"Entered the Required fields successfully");
			Excel.testStatusStoring("New Voter Rejection", 3, "PASS");
		}else{
			Excel.testActualResultsStoring("New Voter Rejection", 3,
					"Unable to Enter the Required fields");
			Excel.testStatusStoring("New Voter Rejection", 3, "FAIL");
		}
		
		
		/*DriverLicenseCheckbox.click();*/
		Review.click();
		
		
		Utility.explicitlyWait(2000);
		
		String rejectionReasonText = RejectionReasonText.getText();
		
		if(rejectionReasonText.equalsIgnoreCase("Voter Registration - New Voter Reject")){
			Excel.testActualResultsStoring("New Voter Rejection", 4,
					"Navigated to the Rejection page successfully");
			Excel.testStatusStoring("New Voter Rejection", 4, "PASS");
		}else{
			Excel.testActualResultsStoring("New Voter Rejection", 4,
					"Unable to Navigate to the Rejection page");
			Excel.testStatusStoring("New Voter Rejection", 4, "FAIL");
		}
		
		RejectionReasondropdown.click();
		
		Utility.explicitlyWait(1000);
		
		RejectionReason.click();
		
		Reject.click();
		
		Utility.explicitlyWait(1000);
		
		String rejectionConfirmation = RejectionConfirmation.getText();
		
		if(rejectionConfirmation.equalsIgnoreCase("Voter has been Rejected.")){
			Excel.testActualResultsStoring("New Voter Rejection", 5,
					"Navigated to the Rejection page successfully");
			Excel.testStatusStoring("New Voter Rejection", 5, "PASS");
		}else{
			Excel.testActualResultsStoring("New Voter Rejection", 5,
					"Unable to Navigate to the Rejection page successfully");
			Excel.testStatusStoring("New Voter Rejection", 5, "FAIL");
		}
		r.addPassStep("Rejection of the Voter", "Rejecting the Voter for the Less age", "Able to Reject the Voter Registration successfully.");
		Ellipses.click();
		LogoutAsCounty.click();

		Utility.explicitlyWait(2000);
		//Reports.log(LogStatus.PASS, "");
		}catch(Exception e){
			r.addFailStep("Rejection of the Voter", "Rejecting the Voter for the Less age", "Error Occured while Rejecting the Voter Registration");
			//Reports.log(LogStatus.FAIL, "Error Occured while Rejecting the Voter Registartion");
		}
		
	}
	
	public Exe_RejectVoterReg(){
		PageFactory.initElements(driver.get(), this);
	}
	
	

}
