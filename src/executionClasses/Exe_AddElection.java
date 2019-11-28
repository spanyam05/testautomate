package executionClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Tools.Excel;
import Tools.Utility;
import baseClass.TestCaseConfiguration;

public class Exe_AddElection extends TestCaseConfiguration {

	Tools.Reports r = new Tools.Reports();

	@FindBy(xpath = "//*[@id='header1']")
	WebElement ElectionManagement;

	@FindBy(xpath = "//div[@class='dropdown-menu dropdown-default animated fadeIn show']//a[@class='text waves-effect waves-light'][contains(text(),'Elections')]")
	WebElement Elections;

	@FindBy(xpath = "//a[@class='btn-add']")
	WebElement Add;

	@FindBy(id = "nmElection")
	WebElement ElectionName;

	@FindBy(xpath = "//body[@id='themeContainer']/form[@id='maintainElection']/div[@id='election-wrapper']/div[@id='electio-content-wrapper']/div[@class='card']/div[@class='card-body']/div[@class='row']/div[@class='col']/div[@class='tab-content mt-0']/div[@class='tab-pane fade show active']/div[@class='row']/div[@class='col']/div[@id='pills-tabContent']/div[@id='elections-electionDetails']/div[@class='row']/div[@class='col-12 col-md-12 col-lg-7 col-xl-7']/div[2]/div[1]/div[1]/input[1]")
	WebElement ElectionCategorydropdown;

	@FindBy(xpath = "//span[contains(text(),'STATE WIDE')]")
	WebElement ElectionCategory;

	@FindBy(xpath = "//body[@id='themeContainer']/form[@id='maintainElection']/div[@id='election-wrapper']/div[@id='electio-content-wrapper']/div[@class='card']/div[@class='card-body']/div[@class='row']/div[@class='col']/div[@class='tab-content mt-0']/div[@class='tab-pane fade show active']/div[@class='row']/div[@class='col']/div[@id='pills-tabContent']/div[@id='elections-electionDetails']/div[@class='row']/div[@class='col-12 col-md-12 col-lg-7 col-xl-7']/div[4]/div[1]/div[1]/input[1]")
	WebElement ElectionTypeDropdown;

	@FindBy(xpath = "/html[1]/body[1]/form[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/ul[1]/li[2]/span[1]")
	WebElement ElectionType;

	@FindBy(xpath = "//body[@id='themeContainer']/form[@id='maintainElection']/div[@id='election-wrapper']/div[@id='electio-content-wrapper']/div[@class='card']/div[@class='card-body']/div[@class='row']/div[@class='col']/div[@class='tab-content mt-0']/div[@class='tab-pane fade show active']/div[@class='row']/div[@class='col']/div[@id='pills-tabContent']/div[@id='elections-electionDetails']/div[@class='row']/div[@class='col-12 col-md-12 col-lg-7 col-xl-7']/div[1]/div[2]/div[1]/input[1]")
	WebElement ElectionDatedropdown;

	@FindBy(xpath = "//span[contains(text(),'12/12/2020')]")
	WebElement ElectionDate;

	@FindBy(xpath = "/html[1]/body[1]/form[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[1]/i[1]")
	WebElement RegistrationDateDatePicker;

	@FindBy(xpath = "//div[@id='closingDate_span_root']//select[@class='picker__select--year']")
	WebElement Year;

	@FindBy(xpath = "//div[@id='closingDate_span_root']//select[@class='picker__select--month']")
	WebElement Month;

	@FindBy(xpath = "//table[@id='closingDate_span_table']//tbody")
	WebElement RegistrationDeadLineDate;

	@FindBy(id = "cutOfDate_span")
	WebElement SupplementalCutoffPlan;

	@FindBy(xpath = "//div[@id='cutOfDate_span_root']//select[@class='picker__select--year']")
	WebElement SupplementalCutoffPlanYear;

	@FindBy(xpath = "//div[@id='cutOfDate_span_root']//select[@class='picker__select--month']")
	WebElement SupplementalCutoffPlanMonth;

	@FindBy(xpath = "//table[@id='cutOfDate_span_table']//tbody")
	WebElement SupplementalCutoffPlanDate;

	@FindBy(id = "dtPrintCommi_span")
	WebElement PrintDate;

	@FindBy(xpath = "//div[@id='dtPrintCommi_span_root']//select[@class='picker__select--year']")
	WebElement PrintDateyear;

	@FindBy(xpath = "//div[@id='dtPrintCommi_span_root']//select[@class='picker__select--month']")
	WebElement PrintDatemnth;

	@FindBy(xpath = "//table[@id='dtPrintCommi_span_table']//tbody")
	WebElement PrintDatedate;

	@FindBy(id = "dtElecCert_span")
	WebElement ElectionCertificationDate;

	@FindBy(xpath = "//div[@id='dtElecCert_span_root']//select[@class='picker__select--year']")
	WebElement ElectionCertificationDateYear;

	@FindBy(xpath = "//div[@id='dtElecCert_span_root']//select[@class='picker__select--month']")
	WebElement ElectionCertificationDateMonth;

	@FindBy(xpath = "//table[@id='dtElecCert_span_table']//tbody")
	WebElement ElectionCertification;

	@FindBy(xpath = "//label[contains(text(),'Open To Counties')]")
	WebElement OpentoCounties;

	@FindBy(id = "addEle")
	WebElement Save;

	@FindBy(id = "addConform")
	WebElement Confirmation1;

	@FindBy(xpath = "//th[contains(text(),'Name')]")
	WebElement Name;

	public void execution() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		excelData = Excel.readDataFromExcel("ElectionAndBallotsAdding");
		js.executeScript("arguments[0].click();", ElectionManagement);
		Utility.explicitlyWait(2000);
		js.executeScript("arguments[0].click();", Elections);
		Add.click();
		Utility.explicitlyWait(2000);
		String electionName = excelData.get("ElectionName");
		ElectionName.sendKeys(electionName);
		ElectionCategorydropdown.click();
		Utility.explicitlyWait(1000);
		ElectionCategory.click();
		ElectionTypeDropdown.click();
		Utility.explicitlyWait(1000);
		ElectionType.click();
		Utility.explicitlyWait(1000);
		ElectionDatedropdown.click();
		Utility.explicitlyWait(1000);
		ElectionDate.click();
		Utility.explicitlyWait(1000);
		RegistrationDateDatePicker.click();
		Utility.explicitlyWait(1000);
		Select year = new Select(Year);
		year.selectByVisibleText("2020");
		Select month = new Select(Month);
		month.selectByVisibleText("August");
		WebElement registrationDeadLineDate = RegistrationDeadLineDate;
		List<WebElement> RAD = registrationDeadLineDate.findElements(By.tagName("td"));
		for (WebElement rad : RAD) {
			if (rad.getText().equals("1")) {
				rad.click();
				break;
			}
		}
		Utility.explicitlyWait(1000);
		SupplementalCutoffPlan.click();
		Utility.explicitlyWait(1000);
		Select Syear = new Select(SupplementalCutoffPlanYear);
		Syear.selectByVisibleText("2020");
		Select Smonth = new Select(SupplementalCutoffPlanMonth);
		Smonth.selectByVisibleText("August");
		WebElement supplementalCutoffPlanDate = SupplementalCutoffPlanDate;
		List<WebElement> SCP = supplementalCutoffPlanDate.findElements(By.tagName("td"));
		for (WebElement scp : SCP) {
			if (scp.getText().equals("1")) {
				scp.click();
				break;
			}
		}
		Utility.explicitlyWait(1000);
		PrintDate.click();
		Utility.explicitlyWait(1000);
		Select Pyear = new Select(PrintDateyear);
		Pyear.selectByVisibleText("2020");
		Select Pmonth = new Select(PrintDatemnth);
		Pmonth.selectByVisibleText("August");
		WebElement printDatedate = PrintDatedate;
		List<WebElement> PD = printDatedate.findElements(By.tagName("td"));
		for (WebElement pd : PD) {
			if (pd.getText().equals("1")) {
				pd.click();
				break;
			}
		}
		Utility.explicitlyWait(1000);
		ElectionCertificationDate.click();
		Utility.explicitlyWait(1000);
		Select Eyear = new Select(ElectionCertificationDateYear);
		Eyear.selectByVisibleText("2020");
		Select Emonth = new Select(ElectionCertificationDateMonth);
		Emonth.selectByVisibleText("August");
		WebElement electionCertification = ElectionCertification;
		List<WebElement> EC = electionCertification.findElements(By.tagName("td"));
		for (WebElement ec : EC) {
			if (ec.getText().equals("1")) {
				ec.click();
				break;
			}
		}
		Utility.explicitlyWait(1000);
		OpentoCounties.click();
		Save.click();
		Utility.explicitlyWait(1000);
		Confirmation1.click();
		Utility.explicitlyWait(2000);
		for (int i = 0; i < 2; i++) {
			Name.click();
		}
		
		

	}

	public Exe_AddElection() {
		PageFactory.initElements(driver.get(), this);
	}

}
