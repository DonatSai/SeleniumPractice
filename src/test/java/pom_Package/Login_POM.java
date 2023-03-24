package pom_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Assignment.NOPCommerce;


public class Login_POM extends NOPCommerce{
	
	public static WebElement Email() {
		
		return (driver.findElement(By.id("Email")));
	}
	
	public static WebElement Password(){
		return (driver.findElement(By.id("Password")));
		
	}

	public static WebElement Submit() {
		return (driver.findElement(By.xpath("//*[@type='submit']")));
	}
}
