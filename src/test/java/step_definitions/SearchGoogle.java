package step_definitions;

import helpers.DataHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modules.GoogleSeachAction;
import modules.SignInAction;
import modules.SignoutAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageobjects.AutomationHomePage;
import pageobjects.GoogleSearchPage;
import pageobjects.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SearchGoogle{
    public WebDriver driver;
//    public List<HashMap<String,String>> datamap = DataHelper.data();
    public static List<HashMap<String,String>> datamap = null;
    
    
    public SearchGoogle()
    {
    	driver = Hooks.driver;
    	
    	datamap = new ArrayList<HashMap<String,String>>();
    	HashMap<String,String> sampleData = new HashMap<String,String>();
    	sampleData.put("email","nirmalkumar99@yahoo.com");
    	sampleData.put("passwd","nirmalbbva12345");
    	System.out.println("Current data" +sampleData);
    	datamap.add(sampleData);
    }
    
    
    @When("^I open google website$")
    public void i_open_google_website() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	driver.get("http://google.com");
    }

    @When("^I search internet$")
    public void i_search_internet() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	PageFactory.initElements(driver, GoogleSearchPage.class);
		GoogleSeachAction.Execute(driver,datamap.get(0));
    }

    @Then("^I click firstlink$")
    public void i_click_firstlink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	//GoogleSeachAction.Execute(driver);
    }
    
    
    
}