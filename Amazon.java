package marathon.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {
	
	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * 01) Launch Chrome 
		 * 02) Load https://www.amazon.in/
		 *  add implicitlyWait
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
		 * 03) Type "Bags" in the Search box 
		 * 04) Choose the item in the result (bags for boys)
		 * 05) Print the total number of results (like 40000) 1-48 of over 40,000
		 * results for "bags for boys" 
		 * 06) Select the first 2 brands in the left menu
		 * (like American Tourister, Generic) 
		 * 07) Choose New Arrivals (Sort) 
		 * 08) Print the first resulting bag info (name, discounted price) 
		 * 09) Get the page title and close the browser(driver.close())
		 */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags");
		driver.findElement(By.xpath("//span[text()=' for boys']")).click();
		String count = driver.findElement(By.xpath("//div[contains(@class,'a-section a-spacing-small a')]")).getText();
		System.out.println(count);
		driver.findElement(By.xpath("//div[@id='brandsRefinements']//a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='brandsRefinements']//a")).click();
		driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).click();
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		System.out.println(driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText());
		System.out.println(driver.findElement(By.xpath("//span[@class='a-price']")).getText());
		
		
		
	}

}


