package com.app;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private AppiumDriver driver; 
	@BeforeTest
    public void beforeTest()
    {
        System.out.println("------Before Test");
    }

	@AfterTest
    public void afterTest()
    {
		System.out.println("------After Test");
    }

	@Test
    public void testApp()
    {
		try {

//			File classpathRoot= new File(System. getProperty( "user.dir"));
//			File appDir= new File(classpathRoot, "apps");
//			File app= new File(appDir, "meituan.apk" );
			DesiredCapabilities capabilities = new DesiredCapabilities(); 
			
//			capabilities.setCapability(capabilities.getBrowserName(), "Android");
//			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("deviceName", "Android Emulator");
			
//            capabilities.setCapability( "app", "com.android.contacts");
//            capabilities.setCapability( "noReset", true);
            //待测apk 包名
            capabilities.setCapability( "appPackage", "com.android.contacts" );
            //待测apk 入口类
            capabilities.setCapability( "appActivity", "com.android.contacts.activities.PeopleActivity");
           
            //AppiumDriver
            driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub" ),capabilities);
//            if(driver.isLocked()){
//            	System.out.println("Locked!");
//            }
//            if(!driver.isLocked()){
//            	System.out.println("unlocked!");
//            }
            System.out.println(driver.findElement(By.name("No contacts.")).getText());
            System.out.println(driver.findElement(By.className("android.widget.TextView")).getText());       	
            System.out.println(driver.findElement(By.id("com.android.contacts:id/message")).getText());       	
        	
            driver.closeApp();
            Thread.sleep(5000);
            
            driver.swipe(100, 400, 400, 400, 300);
            //driver.tap(1, 200, 200, 400);
            //driver.zoom(200, 200);

//            driver.closeApp();
//            driver.launchApp();
            
//            //Add new contact
//            driver.findElementByClassName("android.widget.Button").click();
//            driver.findElementByName("Name").clear();
////        	driver.findElementByName("Name").sendKeys("test");
////        	Thread.sleep(2000);
//        	driver.findElementByName("Phone").clear();
////        	driver.findElementByName("Phone").sendKeys("123123123");
////        	Thread.sleep(2000);
//            driver.findElementByName("Done").click();
            
//            //take screen shot
//            String screenShotName = "test.png"; // 
//            FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File(screenShotName));
            
        	driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
    }
}
