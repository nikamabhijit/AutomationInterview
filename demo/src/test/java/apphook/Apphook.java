package apphook;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import drivers.Drivervalue;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import testrunners.TestRunner;

public class Apphook {
	
	Drivervalue dvalue;
	public WebDriver ldriver;
	
	public Apphook(Drivervalue dvalue) {
		this.dvalue=dvalue;
	}
	
	String browser=TestRunner.Browser.get();

	@Before
    public void launchbrowser()
    {	
		if(browser.equalsIgnoreCase("chrome")) {
			ldriver= WebDriverManager.chromedriver().create();
		} else {
			System.out.println("ldiver is"+ldriver+"browser is");
			ldriver=WebDriverManager.firefoxdriver().clearDriverCache().create();

			
		}
		
		dvalue.setDrive(ldriver); 
		
    }
	
	@After(order = 0)
	public void closebrowser()
    {
		ldriver.quit();
    }
	
	@After(order = 1)
	public void takescreenshot()
    {
		File screenshotFile = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("test-output/pdfReport/screenshot.png"));
        } catch (IOException e) {
            System.err.println("Error saving the screenshot: " + e.getMessage());
        }
    }
}
