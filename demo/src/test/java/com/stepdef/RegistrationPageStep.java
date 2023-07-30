package com.stepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.Registrationpage;

import drivers.Drivervalue;
import excelreader.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import logger.LoggerHelper;

public class RegistrationPageStep {

	Drivervalue drivervalue;
	WebDriver driver;
	Registrationpage lp;
	Logger log;
	String aadharno;
	String name;
	String fathername;
	String dob;
	String address;

	public RegistrationPageStep(Drivervalue drivervalue) {
		this.drivervalue = drivervalue;
		lp = new Registrationpage(drivervalue);
		driver = drivervalue.getDrive();
		log = LoggerHelper.getLogger(LoggerHelper.class);
	}

	@Given("Load Application Url {string}")
	public void load_application_url(String url) {
		driver.get(url);
		log.info("Application load successfully");
	}

	@When("Fetch Data from {string} with {int}")
	public void fetch_Data_from(String sheet, int no) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData("C:\\Users\\Admin\\Desktop\\Data.xlsx", sheet);

		aadharno = testdata.get(no).get("aadhar no");
		name = testdata.get(no).get("name");
		fathername = testdata.get(no).get("Father name");
		dob = testdata.get(no).get("DOB");
		address = testdata.get(no).get("Address");

		log.info("data fetch from excel");
	}

	@When("Enter candidate aadhar no")
	public void enter_candidate_aadhar_no() throws Throwable {
		if (lp.enter_aadharno(aadharno)) {
			log.info("Aadhar No Enter Successfully");
			Assert.assertTrue(true, "Aadhar No Enter Successfully");
		} else {
			log.error("Error to enter Aadhar no");
			Assert.assertTrue(false, "Error to enter Aadhar no");
		}
	}

	@When("Enter candidate name")
	public void enter_candidate_name() throws Throwable {
		if (lp.enter_name(name)) {
			log.info("Candidate Name enter Successfully");
			Assert.assertTrue(true, "Candidate Name enter Successfully");
		} else {
			log.error("Error to Enter Candidate Name");
			Assert.assertTrue(false, "Error to Enter Candidate Name");
		}
	}

	@When("Enter candidate Father name")
	public void enter_candidate_Father_name() throws Throwable {
		if (lp.enter_fathername(fathername)) {
			log.info("Candidate Father Name enter Successfully");
			Assert.assertTrue(true, "Candidate Father Name enter Successfully");
		} else {
			log.error("Error to Enter Candidate Father Name");
			Assert.assertTrue(false, "Error to Enter Candidate Father Name");
		}

	}

	@When("Enter canddate Date of birth")
	public void enter_canddate_Date_of_birth() throws Throwable {
		if (lp.select_date(dob)) {
			log.info("Candidate DOB enter Successfully");
			Assert.assertTrue(true, "Candidate DOB enter Successfully");
		} else {
			log.error("Error to Enter Candidate DOB");
			Assert.assertTrue(false, "Error to Enter Candidate DOB");
		}
	}

	@When("Enter candidate Address")
	public void enter_candidate_Address() throws Throwable {
		if (lp.enter_address(address)) {
			log.info("Candidate Address enter Successfully");
			Assert.assertTrue(true, "Candidate Address enter Successfully");
		} else {
			log.error("Error to Enter Candidate Address");
			Assert.assertTrue(false, "Error to Enter Candidate Address");
		}
	}

}
