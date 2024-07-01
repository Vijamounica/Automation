package vtigerTC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excelfile_Utility;
import Generic_Utility.Java_utility;
import Generic_Utility.Property_file_utility;
import Generic_Utility.Webdriver_utility;
import objectRepositories.CreateNewOrganizationPage;
import objectRepositories.HomePage;
import objectRepositories.LoginPage;
import objectRepositories.OrganizationInfoPage;
import objectRepositories.OrganizationPage;

public class CreateOrgt_test {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		Property_file_utility putil=new Property_file_utility();
		Excelfile_Utility eutil=new Excelfile_Utility();
		Webdriver_utility wutil=new Webdriver_utility();
		Java_utility jutil=new Java_utility();
		//fetch browser name
		String BROWSER = putil.readdatafrompropertyfile("browser");
		System.out.println(BROWSER);
		//Launch browser
		if(BROWSER.equals("edge")) {
			 driver=new EdgeDriver();
		}
		else if(BROWSER.equals("chrome")) {
			 driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			 driver=new FirefoxDriver();
		}
		else {
			System.out.println("INVALID BROWSER NAME");
		}
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver);
		//fetch URL
		String URL = putil.readdatafrompropertyfile("url");
		driver.get(URL);
		//Login to app
		String UN = putil.readdatafrompropertyfile("un");
		String PWD = putil.readdatafrompropertyfile("pwd");
		//Create object of Login apge POM class
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(UN, PWD);
		//Create Object of Homepage
		HomePage h=new HomePage(driver);
		h.clickOnOrganizationLink();
		//click on orgLookup img
		OrganizationPage op=new OrganizationPage(driver);
			op.clickoncreateorgLookUpImg();	
			//give org name
			String orgname = eutil.readDatafromExcel("Sheet1", 0, 0);
			CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
			cnop.createNewOrganization(orgname+jutil.getRandomNum());	
			//click on save btn
			cnop.getSaveBtn();
			//create object of OrganizationInfpage
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String header = oip.getHeader();
			if(header.contains(orgname)) {
				System.out.println("Org is created and TC is pass");
			}
			else{
				System.out.println("TC is failed");
			}
			//logout from app
			h.logOutOfApp(driver);
			
	}

}
