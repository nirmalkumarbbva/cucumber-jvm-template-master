package step_definitions;

import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.File;
import java.io.IOException;

public class Hooks{
    public static WebDriver driver;
    public static ChromeDriverService service;

    
    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {
    	System.out.println("Called openBrowser");

    	service = new ChromeDriverService.Builder()
        	        .usingDriverExecutable(new File("/Users/nirmalkumar/Downloads/chromedriver"))
        	        .usingAnyFreePort()
        	        .build();
        	
		try {
			service.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		
	 	System.out.println("111 - service.getUrl()::::"+service.getUrl());
    	driver= new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());  
    	
    	// driver = new ChromeDriver();
    	// Test
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
    	
    	
    }

     
    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
       
        if(scenario.isFailed()) {
        try {
        	 scenario.write("Current Page URL is " + driver.getCurrentUrl());
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        
        }
        
       driver.quit();
       service.stop();
        
    }
    
}