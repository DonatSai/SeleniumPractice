package Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ReusableMethods extends NOPCommerce{

	

	public static String Dataprop(String key) throws Exception {
		FileInputStream fis = new FileInputStream("./Resources/data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public static String ScreenCapture(WebDriver driver) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("/Assignments/Screenshots/" +System.currentTimeMillis() +".png");
		String errflpath = DestFile.getAbsolutePath();
		FileUtils.copyFile(SrcFile, DestFile);
		return errflpath;
}
}