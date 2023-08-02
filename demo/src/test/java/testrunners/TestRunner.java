package testrunners;

import io.cucumber.testng.CucumberOptions;

import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/test/resource/features/demo.feature",
    glue = {"apphook","com.stepdef"},
    tags = "@tag1", // Optionally, you can use tags to run specific scenarios
    monochrome=true,
    plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestRunner  extends AbstractTestNGCucumberTests 	{
	
	public static ThreadLocal<String> Browser = new ThreadLocal<String>();
	
	public static ThreadLocal<Properties> lprop=new ThreadLocal<Properties>() {
		protected Properties initialValue() {
			return new Properties();
		}
	};
	
	@Parameters({"browser"})
	@BeforeClass
	public static void setupscenario(String browser) {
		TestRunner.Browser.set(browser);
		System.out.println("browser name is"+browser);
	
	}
}
