package com.insuremetest.InsureMe;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class InsureMeApplication {

	public static void main( String[] args ) throws InterruptedException, IOException
    {
     
    	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    	ChromeOptions chromeoptions = new ChromeOptions();
    	chromeoptions.addArguments("--headless=new");
    	chromeoptions.addArguments("--remote-allow-origins=*");
    	WebDriver driver = new ChromeDriver(chromeoptions);
    	
    	System.out.println("Selenium test script has started....");
    	
    	//open browser
    		
    	
    	driver.get("http://54.226.140.109:8081/contact.html");
    	Thread.sleep(2000);
    	//click on new contact 
        //driver.findElement(By.className("v-button")).click();
    	//enter all the details
        driver.findElement(By.id("inputName")).sendKeys("Palash");
        
        driver.findElement(By.id("inputNumber")).sendKeys("987654321");
        
        driver.findElement(By.id("inputMail")).sendKeys("palash@gmail.com");
        														
        driver.findElement(By.id("inputMessage")).sendKeys("Hello, i am interested and have an inquiry");
        												
        driver.findElement(By.id("my-button")).click();
        
    	//click on save after to store the information in the address book
    	//driver.findElement(By.className("v-button-primary")).click();
    	
    	String successMessage = driver.findElement(By.id("response")).getText();
    	String expectedMessage = "Message Sent";
    	assert successMessage.equals(expectedMessage) : "Success message is incorrect" + successMessage;
    	
    	
    	Thread.sleep(2000);
    	
    	TakesScreenshot scrShot = ((TakesScreenshot)driver);
    	
    	File srcFile= scrShot.getScreenshotAs(OutputType.FILE);

    	File destFile = new File("/home/ubuntu/test-artifact/artifact.png");
    	
    	FileUtils.copyFile(srcFile, destFile);
    	
    	driver.quit();
    	
    	//Thread.sleep(2000);
    	
    	System.out.println("Scripts executed successfully");
    	
	}

}
