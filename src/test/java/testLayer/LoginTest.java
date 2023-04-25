package testLayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseHRMClass;
import pompackage.POMLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRMClass {
	POMLogin log;
	
	public LoginTest() {
		super();
		
	}
		@BeforeMethod
		public void initsetup() throws InterruptedException {
			initiation();
			Thread.sleep(3000);
			screenshots("Login");
			log = new POMLogin();
			
		}
		@DataProvider
		public Object[][] information(){
			Object result[][]= ExcelSheet.readdata("Sheet1");
			return result;
		}
		@Test(dataProvider= "information")
		public void login(String name, String pword) {
			log.typeusername(name);
			log.typepassword(pword);
			//log.logbtn();
			
			//log.typeusername("test");
			//log.typepassword("test1");
		}
		@AfterMethod
		public void close() throws InterruptedException {
			
			
			driver.close();
		}
}
