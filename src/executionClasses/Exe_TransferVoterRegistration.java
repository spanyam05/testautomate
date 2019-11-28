package executionClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tools.Excel;
import Tools.Utility;
import baseClass.TestCaseConfiguration;

public class Exe_TransferVoterRegistration extends TestCaseConfiguration {
	
	Tools.Reports r = new Tools.Reports();
	
	@FindBy(xpath = "//i[@class='fa fa-ellipsis-v desktop-view']")
	WebElement Ellipses;

	@FindBy(xpath = "//a[contains(text(),'Login As County')]")
	WebElement LoginAsCounty;
	
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
	
	@FindBy(xpath="//*[@id='electio-content-wrapper']/div[1]/nav/ol/li[3]")
	WebElement TransferVotertext;
	
	@FindBy(id = "actionBar")
	WebElement ActionBar;

	@FindBy(xpath = "//*[@id='electio-content-wrapper']/div[2]/div/h1/span/ul/li")
	WebElement EditVoterDetails;
	
	@FindBy(id = "dtLastContact_span")
	WebElement ContactDatedatepicker;

	@FindBy(xpath = "//*[@id='dtLastContact_span_root']/div/div/div/div/div[2]/button[1]")
	WebElement ContactDateTodaysDate;
		
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

	@FindBy(xpath = "//*[@id='streetNumberCheck0']")
	WebElement Addressclick;

	@FindBy(xpath="//*[@id='pills-tabContent']/div/div[7]/div[5]/div/div/div/p")
	WebElement ResidenceAddressValidation;
	
	 @FindBy(id="Continue")
	 WebElement ReviewScreen;
	 
	 @FindBy(xpath="//*[@id='pills-tabContent']/div/h2")
	 WebElement ReviewScreenConfirmation;
	 
	 @FindBy(xpath="//*[@id='pills-tabContent']/div/div[6]/div/button[2]")
	 WebElement Save;
	
@FindBy(xpath="//*[@id='voterRegistration']/div[4]/div/p")
WebElement FinalConfirmation;

	
	
	public void execution() throws Exception{
		try{
		
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		excelData = Excel.readDataFromExcel("TransferVoterRegistration");
		
		Ellipses.click();
		LoginAsCounty.click();

		Utility.explicitlyWait(2000);
		
		Loginascountybutton.click();

		// Excel.testResultsStoring("Registration", 1, "PASS");

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
		if(x==0){
			Excel.testActualResultsStoring("Transfer Voter Registration", 1,
					"Login to the county was not successfull");
			Excel.testStatusStoring("Transfer Voter Registration", 1, "FAIL");
		}
		else{
			Excel.testActualResultsStoring("Transfer Voter Registration", 1,
					"Login to the county was successfull");
			Excel.testStatusStoring("Transfer Voter Registration", 1, "PASS");
		}
		
		js.executeScript("arguments[0].click()", VoterManagement);

		js.executeScript("arguments[0].click()", VoterSearchInformation);

		Utility.explicitlyWait(2000);
		
		String vid = excelData.get("VID");
		VoterID.sendKeys(vid);

		DuplicateSearch.click();

		Utility.explicitlyWait(1000);

		VoterResults.click();

		Utility.explicitlyWait(2000);
		
		String transferVotertext = TransferVotertext.getText();
		
		if(transferVotertext.equalsIgnoreCase("Transfer Voter")){
			Excel.testActualResultsStoring("Transfer Voter Registration", 2,
					"Navigated to the Transfer Voter screen successfully");
			Excel.testStatusStoring("Transfer Voter Registration", 2, "PASS");
		}else{
			Excel.testActualResultsStoring("Transfer Voter Registration", 2,
					"Unable to Navigate to the Transfer Voter screen");
			Excel.testStatusStoring("Transfer Voter Registration", 2, "FAIL");
		}
		
		js.executeScript("arguments[0].click()", ActionBar);

		EditVoterDetails.click();
		
		ContactDatedatepicker.click();

		Utility.explicitlyWait(1000);

		ContactDateTodaysDate.click();

		Utility.explicitlyWait(2000);

		
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
		
		String residenceAddressValidation = ResidenceAddressValidation.getText();
		
		if(residenceAddressValidation.equalsIgnoreCase("252 W. PARKER ST. BAXLEY GA 31513")){
			Excel.testActualResultsStoring("Transfer Voter Registration", 3,
					"Entered the Residence Address details successfully");
			Excel.testStatusStoring("Transfer Voter Registration", 3, "PASS");
		}
		else{
			Excel.testActualResultsStoring("Transfer Voter Registration", 3,
					"Unable to enter the Residence Address details");
			Excel.testStatusStoring("Transfer Voter Registration", 3, "FAIL");
		}
		
		ReviewScreen.click();
		
		Utility.explicitlyWait(1000);
		
		
		String reviewScreenConfirmation = ReviewScreenConfirmation.getText();
		
		if(reviewScreenConfirmation.equalsIgnoreCase("Voter Registration Review")){
			Excel.testActualResultsStoring("Transfer Voter Registration", 4,
					"Navigated to the Review screen successfully");
			Excel.testStatusStoring("Transfer Voter Registration", 4, "PASS");
		}else{
			Excel.testActualResultsStoring("Transfer Voter Registration", 4,
					"Unable to navigate to Review screen");
			Excel.testStatusStoring("Transfer Voter Registration", 4, "FAIL");
		}
		
		Save.click();
		
		String finalConfirmation =  FinalConfirmation.getText();
		if(finalConfirmation.equalsIgnoreCase("Voter Registration Completed Successfully")){
			Excel.testActualResultsStoring("Transfer Voter Registration", 5,
					"Able to comeplete the Transfer Voter Registration successfully");
			Excel.testStatusStoring("Transfer Voter Registration", 5, "PASS");
		}else{
			Excel.testActualResultsStoring("Transfer Voter Registration", 5,
					"Error occured while comepleting the Transfer Voter Registration");
			Excel.testStatusStoring("Transfer Voter Registration", 5, "FAIL");
		}
		r.addPassStep("Verification of Transfer Voter Registration", "Verification of Transfer Voter Registration", "Able to Transfer the Voter successfully");
		}catch(Exception e){
			r.addFailStep("Verification of Transfer Voter Registration", "Verification of Transfer Voter Registration", "unable to Transfer the Voter successfully");
		}
		
		
	}
	
	
	
	public Exe_TransferVoterRegistration(){
		PageFactory.initElements(driver.get(), this);
	}

}
