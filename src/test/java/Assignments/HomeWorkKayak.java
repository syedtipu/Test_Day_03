package Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeWorkKayak {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kayak.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Flights")).click();
		// $x("//div[@class='RVNB-menu-item-title RVNB-active']") why it does not work
		// on selenium.
		// a[@class='RVNB RVNB-active']//*[name()="svg"] this xpath doesnot work as
		// well.
		// driver.findElement(By.xpath("//div[contains(@class, 'RVNB-menu-item-title
		// RVNB')]")).click(); another doesnot work as well.

		driver.findElement(By.xpath("(//section/div/div/div/div/div/div/div[@role='button'])[1]")).click();
		driver.findElement(By.cssSelector("li[id*='switch-option-2']")).click();
		driver.findElement(By.cssSelector("div[id*='origin-airport-display")).click();
		driver.findElement(By.xpath("//div[contains(@id,'origin-airport-smarty-wrapper')]/div[2]/div/div[2]/button[1]"))
				.click();
		driver.findElement(By.cssSelector("input[id*='origin-airport']")).sendKeys("JFK");
		driver.findElement(By.xpath("//*[text()='John F Kennedy Intl']")).click();

		/*
		 * List<WebElement> Destinations =
		 * driver.findElements(By.xpath("//div[@class='item-info']/div")); for
		 * (WebElement destination :Destinations) {
		 * if(destination.getText().equalsIgnoreCase("Dhaka, Bangladesh")) {
		 * destination.click(); break; } }
		 */

		driver.findElement(By.cssSelector("div[id*='destination-airport']")).click();
		driver.findElement(By.cssSelector("input[id*='destination-airport']")).sendKeys("DH");
		driver.findElement(By.xpath("//*[text()='Dhaka, Bangladesh']")).click();
		driver.findElement(By.cssSelector("div[id*=dates-col] div[id*=dateRangeInput-display]")).click();
		driver.findElement(By.xpath("//div[contains(@id, 'cal-defaultView')]//div[@aria-label='Next month']")).click();
		driver.findElement(By.xpath("//div[contains(@id, 'jam-cal-20210')] //div[@aria-label='March 16']")).click();
		driver.findElement(By.xpath("//span[@class='icon ']")).click();
		// "//span[@class='icon ']//*[name()='svg']" this one worked for click on search

		Thread.sleep(5000);
		Actions jakir = new Actions(driver);
		jakir.moveToElement(driver.findElement(By.xpath("//body"))).sendKeys(Keys.ESCAPE).build().perform();
		/*
		 * driver.findElement(By.xpath(
		 * "//button[@id='fwuq-dialog-close']//*[local-name()='svg']")).click(); this
		 * x-path dosnot work to close the pop up window
		 */
		System.out.println(driver.findElement(By.xpath("//div[@class='warning-msg']")).getText());

		List<WebElement> result = driver
				.findElements(By.xpath("//div[@id='searchResultsList']/div/div[2]/div/div/div[2]"));

		for (int i = 0; i < 1; i++) {
			System.out.println("For Best Deal*****************");
			System.out.println(result.get(i).getText());
			System.out.println("****************************");
		}

		List<WebElement> cheapest = driver
				.findElements(By.xpath("//div[@id='searchResultsList']/div/div[2]/div/div/div[1]"));
		for (int k = 0; k < 1; k++) {
			System.out.println("For Cheapest Deal******************");
			System.out.println(cheapest.get(k).getText());
			System.out.println("*****************************");
		}
		driver.findElement(By.xpath(
				"//div[@id='searchResultsList']/div/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[@class='col col-best']"))
				.click();
		driver.findElement(By.xpath(
				"//div[@id='searchResultsList']/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[@class='col col-best']"))
				.click();
	}

}
