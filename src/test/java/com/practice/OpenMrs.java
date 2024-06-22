package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.base.base;

public class OpenMrs extends base {
	
	base b = new base();
	
	@Test
	public void login() throws InterruptedException
	{
		b.launchBrowser();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("Admin123");
		driver.findElement(By.xpath("//li[text()='Registration Desk']")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.id("loginButton")).click();
	}
	
	@Test
	public void regpatient() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']")).click();
	
		//name
		
		driver.findElement(By.name("givenName")).sendKeys("pratiksha");
		driver.findElement(By.name("middleName")).sendKeys("mahesh");
		driver.findElement(By.name("familyName")).sendKeys("patil");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
		
		
		//gender
		Thread.sleep(3000);
		driver.findElement(By.xpath("//option[text()='Female']")).click();    
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
		
		
		
		//Birthdate
		
		driver.findElement(By.id("birthdateDay-field")).sendKeys("28");
		
		WebElement ele = driver.findElement(By.name("birthdateMonth"));
		
		Select s1 = new Select(ele);
		s1.selectByValue("11");
		
		driver.findElement(By.id("birthdateYear-field")).sendKeys("1999");
		driver.findElement(By.id("next-button")).click();
		
		//Address
		
		driver.findElement(By.id("address1")).sendKeys("pune");
		driver.findElement(By.id("address2")).sendKeys("punawale");
		driver.findElement(By.id("cityVillage")).sendKeys("punawale");
		driver.findElement(By.id("stateProvince")).sendKeys("maharashtra");
		driver.findElement(By.id("country")).sendKeys("india");
		driver.findElement(By.id("postalCode")).sendKeys("411033");
		driver.findElement(By.id("next-button")).click();
		
		//phonenumber
		
		driver.findElement(By.name("phoneNumber")).sendKeys("9921697654");
		driver.findElement(By.id("next-button")).click();
		
		
		//Relatives
		
		WebElement ele1 = driver.findElement(By.id("relationship_type"));
		Select s2 = new Select(ele1);
		s2.selectByValue("8d91a210-c2cc-11de-8d13-0010c6dffd0f-A");
		
		driver.findElement(By.xpath("//input[@placeholder='Person Name']")).sendKeys("sister");
		driver.findElement(By.id("next-button")).click();
	}
	
	
	
	
		
				
	
	
	
	
	
	

}
