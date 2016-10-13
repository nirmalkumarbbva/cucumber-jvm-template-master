package modules;

import helpers.Log;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pageobjects.AutomationHomePage;
import pageobjects.GoogleSearchPage;
import pageobjects.LoginPage;


public class GoogleSeachAction {

	public static void Execute(WebDriver driver,HashMap<String,String> map) throws Exception{
		
		//Thread.sleep(5000L);
		//driver.findElement(By.name("q")).sendKeys("abc");
		driver.findElement(By.name("q")).submit();
		Thread.sleep(10000L);
		
/*		Log.info("Click action is perfromed on My Account link" );
		System.out.println("Click action is perfromed on My Account link");

		LoginPage.email.sendKeys(map.get("username"));

		Log.info(" is entered in UserName text box" );
		System.out.println("is entered in UserName text box");
		
		LoginPage.password.sendKeys(map.get("password"));
		Log.info(" is entered in Password text box" );
		System.out.println(" is entered in Password text box" );
		

		LoginPage.signin_button.click();
*/		Log.info("Click action is performed on Submit button");
		System.out.println(" Click action is performed on Submit button" );

		Reporter.log("Search Action is successfully perfomred");

	}
}
