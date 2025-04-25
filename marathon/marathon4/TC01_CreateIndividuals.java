package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC01_CreateIndividuals extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setValues() {
		excelFileName = "CreateIndividuals";
		testcaseName = "CreateIndividuals";
		testDescription ="Verify that the individual is created";
		authors="Bhavani";
		category ="Smoke";
	}
	
	@Test(dataProvider = "fetchData")
	public void runLogin(String uname,String pass,String lastName) throws InterruptedException {
	LoginPage lp=new LoginPage();
	lp.enterUsername(uname).enterPassword(pass).clickLogin().clickToggleMenu().
		clickViewAll().clickIndividuals().clickDropdownIndividuals().clickNewIndividual().
		enterLastName(lastName).clickSave().verifyIndividualsName(lastName);
	}
}
