package marathonTestcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBus {

	/* 01) Launch Firefox / Chrome
	 * 02) Load https://www.redbus.in/
	 * 03) Type ""Chennai"" in the FROM text box
	 * 04) Type ""Bangalore"" in the TO text box
	 * 05) Select tomorrow's date in the Date field
	 * 06) Click Search Buses
	 * 07) Print the number of buses shown as results (104 Buses found)
	 * 08) Choose SLEEPER in the left menu 
	 * 09) Print the name of the second resulting bus 
	 *10) Click the VIEW SEATS of that bus
	 */
	
	public static void main(String[] args) throws InterruptedException {
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.redbus.in/");		
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//li[text()='Chennai']")).click();
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[text()='Bangalore']")).click();
		driver.findElement(By.xpath("//span[contains(@class,'fl icon-calendar')]")).click();
		driver.findElement(By.xpath("(//td[@class='wd day'])[1]")).click();
		driver.findElement(By.id("search_btn")).click();
		
		/*
		 * WebElement prime =
		 * driver.findElement(By.xpath("//div[@class='close-primo']"));
		 * driver.executeScript("arguments[0].click();",prime);
		 */	String bus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println(bus);
		WebElement sleeper = driver.findElement(By.xpath("//label[text()='SLEEPER']"));
		driver.executeScript("arguments[0].click();",sleeper);
		String text = driver.findElement(By.xpath("(//div[contains(@class,'travels lh-24')])[2]")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("(//div[@class='button view-seats fr'])[2]")).click();
		
		
		
	}

}
