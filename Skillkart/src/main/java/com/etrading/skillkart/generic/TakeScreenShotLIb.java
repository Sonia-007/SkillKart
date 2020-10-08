package com.etrading.skillkart.generic;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TakeScreenShotLIb {
	
	public static String screenShot(WebDriver driver,String imagepath,String testcasename) {
		LocalDateTime ldt = LocalDateTime.now();
		String date = ldt.toString().replace(":","-");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=imagepath+testcasename+date+".png";
		File dest=new File(imagepath+testcasename+date+".png");
		try {
		 FileUtils.copyFile(src, dest);
		 return path;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static String screenShot(WebDriver driver,String imagepath,String testcasename,WebElement target ) {
		LocalDateTime ldt = LocalDateTime.now();
		String date = ldt.toString().replace(":","-");
		File src=target.getScreenshotAs(OutputType.FILE);
		String path=imagepath+testcasename+date+".png";
		File dest=new File(imagepath+testcasename+date+".png");
		try {
		 FileUtils.copyFile(src, dest);
		 return path;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
