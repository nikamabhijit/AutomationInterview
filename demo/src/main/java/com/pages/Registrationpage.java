package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import drivers.Drivervalue;

public class Registrationpage 
{

	WebDriver driver;
	
	public Registrationpage(Drivervalue ldriver) {
		PageFactory.initElements(ldriver.getDrive(), this);
		driver=ldriver.getDrive();
	}
	
	// ====================== page factory =================================
	
	@FindBy(name = "tb_AdhaarNo")
	WebElement rp_aadharno;
	
	@FindBy(name = "tb_Name")
	WebElement rp_name;
	
	@FindBy(name = "tb_FatherName")
	WebElement rp_fathername;
	
	@FindBy(id = "dateControl_dd_day")
	WebElement rp_day;
	
	@FindBy(id = "dateControl_dd_month")
	WebElement rp_month;
	
	@FindBy(id = "dateControl_dd_year")
	WebElement rp_year;
	
	@FindBy(id = "tb_address")
	WebElement rp_address;
	
	// ====================== Web Element Action =================================
	
	public boolean registrationpage_success() {
		if(rp_aadharno.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean enter_aadharno(String aadharno) {
		if(rp_aadharno.isDisplayed()) {
			rp_aadharno.sendKeys(aadharno);
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean enter_name(String name) {
		if(rp_name.isDisplayed()) {
			rp_name.sendKeys(name);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean enter_fathername(String fname) {
		if(rp_fathername.isDisplayed()) {
			rp_fathername.sendKeys(fname);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean select_date(String date) {
		String day=date.split("-")[0];
		String month=date.split("-")[1];
		String year=date.split("-")[2];
		if(rp_day.isDisplayed()) {
			Select selday=new Select(rp_day);
			Select selmonth=new Select(rp_month);
			Select selyear=new Select(rp_year);
			selday.selectByValue(day);
			selmonth.selectByValue(month);
			selyear.selectByValue(year);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean enter_address(String add) {
		if(rp_address.isDisplayed()) {
			rp_address.sendKeys(add);
			return true;
		}else {
			return false;
		}
	}
	
}
