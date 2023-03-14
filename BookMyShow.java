package marathonTestcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * 01) Launch Edge / Chrome 
		 * 02) Load https://in.bookmyshow.com/
		 * 03) Type the city as ""Hyderabad"" in Select City 
		 * 04) Confirm the URL has got loaded with Hyderabad 
		 * 05) Search for your favorite movie 
		 * 06) Click Book Tickets 
		 * 07) Print the name of the theater displayed first 
		 * 08) Click on the info of the theater
		 * 09) Confirm if there is a parking facility in the theater 
		 * 10) Close the theater popup 
		 * 11) Click on the first green (available) timing 
		 * 12) Click Accept 
		 * 13) Choose 1 Seat and Click Select Seats 
		 * 14) Choose any available ticket and Click Pay 
		 * 15) Print the sub total 
		 * 16) Take screenshot and close browser
		 */

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://in.bookmyshow.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//input[@class='sc-hCaUpS cLnzvB']")).sendKeys("Hyderabad");
		
		driver.findElement(By.xpath("//span[@class='sc-dBaXSw gYlrLO']")).click();
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("hyderabad")) {
			
			System.out.println("The Url contains Hyderabad");
			
		}else {
			System.out.println("The Url has no Hyderabad in it");
		}
		
		driver.findElement(By.xpath("//span[@class='sc-fcdeBU cNeUMt']")).click();
		driver.findElement(By.xpath("//input[@class='sc-hCaUpS cLnzvB']")).sendKeys("Sir");
		driver.findElement(By.xpath("//strong[text()='Sir']")).click();
		driver.findElement(By.xpath("//span[text()='Book tickets']")).click();
		System.out.println(driver.findElement(By.xpath("//a[@class='__venue-name']")).getText());
		driver.findElement(By.xpath("//div[@class='venue-info-text']")).click();
		String facility = driver.findElement(By.xpath("(//div[@class='facility-text'])[2]")).getText();
		System.out.println(facility);
		if(facility.equalsIgnoreCase("Parking Facility")) {
			
			System.out.println("The theatre has a parking facility");
		}
		driver.findElement(By.xpath("//div[@class='cross-container']")).click();
		driver.findElement(By.xpath("//div[@class='__details']")).click();
		driver.findElement(By.xpath("//li[@id='pop_1']")).click();
		
		driver.findElement(By.xpath("//div[@id='proceed-Qty']")).click();
		driver.findElement(By.xpath("//a[@class='_available']")).click();
		driver.findElement(By.xpath("//a[@id='btmcntbook']")).click();
		Thread.sleep(2000);
		String price = driver.findElement(By.xpath("//span[@id='subTT']")).getText();
		Thread.sleep(2000);
		System.out.println(price);
		
		
	}

}
