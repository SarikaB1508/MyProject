package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseHRMClass;

public class POMLogin extends BaseHRMClass{

		@FindBy(name="username") WebElement username;
		@FindBy(name="password") WebElement password;
		@FindBy(xpath ="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button") WebElement loginbtn;
		
public POMLogin() {
	PageFactory.initElements(driver, this);
}

public void typeusername(String name) {
	username.sendKeys(name);
}

public void typepassword(String pword) {
	password.sendKeys(pword);
}
public void logbtn() {
	//loginbtn.click();
	}
}


