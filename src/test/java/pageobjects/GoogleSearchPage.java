package pageobjects;
import helpers.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class GoogleSearchPage extends BaseClass{

	public GoogleSearchPage(WebDriver driver){
		super(driver);
	}    

	// Test
	@FindBy(how=How.ID_OR_NAME, using="Search")
	public static WebElement search;
	
	
	
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	