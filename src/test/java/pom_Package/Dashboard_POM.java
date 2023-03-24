package pom_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Assignment.NOPCommerce;


public class Dashboard_POM extends NOPCommerce{
	
	
	public static WebElement Catalog() {
		return (driver.findElement(By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[2]/a")));
	}
	
	public static WebElement pdts() {
		return(driver.findElement(By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[2]/ul/li[1]/a/p")));
	}
}
