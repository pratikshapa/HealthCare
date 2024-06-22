package com.base;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	
		public static Properties property;
		public static WebDriver driver;
		public static ChromeOptions option;
		
		public base() 
		{
			String path = System.getProperty("user.dir")+"\\properties"+"\\config.properties";
			
			try {
				FileInputStream file = new FileInputStream(path);
				property = new Properties();
				property.load(file);
				} 
				
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			
		}
		
			public static void initializBrowser()
			{
				String browsername = property.getProperty("browser");
				if(browsername.equals("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					option = new ChromeOptions();
					option.addArguments("--disable-notifications");
					driver = new ChromeDriver();
				}
				else if(browsername.equals("edge")) 
				{
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					
				}
				else if(browsername.equals("firefox")) 
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					
				}
				
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(4000));
				
				driver.get(property.getProperty("url"));
			}
		
		
}
