package com.etrading.skillkart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.etrading.skillkart.generic.WebActionUtil;

public class LoginPage extends BasePage {
	@FindBy(partialLinkText="Sign in")
	WebElement signUp;
	@FindBy(id="email") 
	WebElement username;
	@FindBy(id="passwd")
	WebElement password;
	@FindBy(linkText="Forgot your password?")
	WebElement forgotPasswordLink;
	@FindBy(id="SubmitLogin")
	WebElement submittButton;
	@FindBy(id="SubmitCreate")
	WebElement creatAccount;
	HomePage hp;
	@FindBy(id="email_create")
	WebElement emailTB;
	@FindBy(id="account-creation_form")
	WebElement registrationForm;
	@FindBy(xpath="//div[@class=\"account_creation\"]//p/")
	WebElement addressform;
	@FindBy(id="days")
	WebElement dayListBox;
	@FindBy(id="months")
	WebElement monthListBox;
	@FindBy(id="years")
	WebElement yearListBox;
	@FindBy(id="id_state")
	WebElement stateListBox;
	@FindBy(id="other")
	WebElement add_information;
	@FindBy(id="submitAccount")
	WebElement register_bt;
public LoginPage(WebDriver driver,WebActionUtil webActionUtil) {
	super(driver,webActionUtil);
}

public HomePage login(String un,String pwd) throws Exception {
	webActionUtil.click(signUp);
	Thread.sleep(5);
	webActionUtil.enterKeys(un, username);
	webActionUtil.enterKeys(pwd, password);
	webActionUtil.click(submittButton);
	
	hp=new HomePage(driver,webActionUtil);
	return hp;

}


public HomePage login(String ...a) {
webActionUtil.enterKeys(a[0],emailTB);
webActionUtil.click(creatAccount);
List<WebElement>formMenu=registrationForm.findElements(By.tagName("input"));

for(WebElement element:formMenu) {
	if(element.getAttribute("type").equalsIgnoreCase("radio")) {
		if(element.getAttribute("value").equalsIgnoreCase(a[1]))
		{
			webActionUtil.click(element);
			
		}
		if(element.getAttribute("type").equalsIgnoreCase("checkbox")) {
			if(element.getAttribute("value").equalsIgnoreCase(a[2]))
			{
				webActionUtil.click(element);
				
			}
		}
			else if(element.getAttribute("value").equalsIgnoreCase(a[3]))
					{
				webActionUtil.click(element);
					}
	}
	
	if(element.getAttribute("type").equalsIgnoreCase("text")) {
		
			if(element.getAttribute("id").equalsIgnoreCase("customer_firstname"))
			{
			webActionUtil.enterKeys(a[4],element);
			}	
	
			if(element.getAttribute("id").equalsIgnoreCase("customer_lastname"))
			{
				webActionUtil.enterKeys(a[5],element);
			}
					
			if(element.getAttribute("id").equalsIgnoreCase("email"))
			{
				webActionUtil.enterKeys(a[6],element);
			}
		
			if(element.getAttribute("id").equalsIgnoreCase("passwd"))
			{
			webActionUtil.enterKeys(a[7],element);
			}
			
			if(element.getAttribute("id").equalsIgnoreCase("passwd"))
			{
			webActionUtil.enterKeys(a[8],element);
			}
	}
	
}

Select s1 =new Select(dayListBox);
s1.selectByValue(a[9]);
Select s2 =new Select(monthListBox);
s2.selectByValue(a[10]);
Select s3 =new Select(yearListBox);
s3.selectByValue(a[11]);
Select s4 =new Select(stateListBox);
s3.selectByVisibleText(a[12]);

webActionUtil.enterKeys("data", add_information);

List<WebElement>addressMenu=addressform.findElements(By.tagName("input"));
for(WebElement element:addressMenu) {
if(element.getAttribute("type").equalsIgnoreCase("text")) {
	
	if(element.getAttribute("id").equalsIgnoreCase("firstname"))
	{
	webActionUtil.enterKeys(a[13],element);
	}	

	if(element.getAttribute("id").equalsIgnoreCase("lastname"))
	{
		webActionUtil.enterKeys(a[14],element);
	}

	if(element.getAttribute("id").equalsIgnoreCase("company"))
	{
		webActionUtil.enterKeys(a[15],element);
	}
	if(element.getAttribute("id").equalsIgnoreCase("address1"))
	{
		webActionUtil.enterKeys(a[16],element);
	}
	if(element.getAttribute("id").equalsIgnoreCase("address2"))
	{
		webActionUtil.enterKeys(a[17],element);
	}
	if(element.getAttribute("id").equalsIgnoreCase("city"))
	{
		webActionUtil.enterKeys(a[18],element);
	}
	if(element.getAttribute("id").equalsIgnoreCase("postcode"))
	{
		webActionUtil.enterKeys(a[19],element);
	}
	if(element.getAttribute("id").equalsIgnoreCase("phone"))
	{
		webActionUtil.enterKeys(a[20],element);
	}
	
	if(element.getAttribute("id").equalsIgnoreCase("phone_mobile"))
	{
		webActionUtil.enterKeys(a[21],element);
	}
	
	if(element.getAttribute("id").equalsIgnoreCase("alias"))
	{
		webActionUtil.enterKeys(a[22],element);
	}
}
}
webActionUtil.click(register_bt);

return new HomePage(driver,webActionUtil);


}
}
