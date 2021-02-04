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

public class KayakHWPart1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kayak.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Flights")).click();
		// driver.findElement(By.cssSelector("svg[aria-label='Flights icon']")).click();
		driver.findElement(By.xpath("(//section/div/div/div/div/div/div/div[@role='button'])[1]")).click();
		driver.findElement(By.cssSelector("li[id*='switch-option-2']")).click();
		driver.findElement(By.cssSelector("div[id*='origin-airport-display")).click();
		driver.findElement(By.xpath("//div[contains(@id,'origin-airport-smarty-wrapper')]/div[2]/div/div[2]/button[1]"))
				.click();

		driver.findElement(By.cssSelector("input[id*='origin-airport']")).sendKeys("NYC");
		List<WebElement> Options = driver.findElements(By.cssSelector("div[class='item-info'] div"));
		for (WebElement option : Options) {
			if (option.getText().equalsIgnoreCase("John F Kennedy Intl")) {
				option.click();
				break;
			}
		}

		driver.findElement(By.cssSelector("div[id*='destination-airport']")).click();
		driver.findElement(By.cssSelector("input[id*='destination-airport']")).sendKeys("DH");
		driver.findElement(By.xpath("//*[text()='Dhaka, Bangladesh']")).click();
		driver.findElement(By.cssSelector("div[id*=dates-col] div[id*=dateRangeInput-display]")).click();
		driver.findElement(By.xpath("//div[contains(@id, 'cal-defaultView')]//div[@aria-label='Next month']")).click();
		driver.findElement(By.xpath("//div[contains(@id, 'jam-cal-20210')] //div[@aria-label='March 16']")).click();
		driver.findElement(By.xpath("//span[@class='icon ']")).click();
		Thread.sleep(5000);
		Actions popup = new Actions(driver);
		popup.moveToElement(driver.findElement(By.xpath("//body"))).sendKeys(Keys.ESCAPE).build().perform();
		System.out.println(driver.findElement(By.xpath("//div[@class='warning-msg']")).getText());
		driver.findElement(By.xpath("//div[@id='searchResultsList']/div/div[2]")).click();

		List<WebElement> result = driver.findElements(By.xpath("//div[@id='searchResultsList']/div/div[2]"));

		for (int i = 0; i < 1; i++) {
			System.out.println("Best and Cheapest Deal*****************");
			System.out.println(result.get(i).getText());
			System.out.println("****************************");
		}

		/*
		 * List<WebElement> result1 = driver.findElements(By.xpath(
		 * "//div[@id='searchResultsList']/div/div[2]/div/div/div[2]"));
		 * 
		 * for(int i=0; i<1; i++) {
		 * System.out.println("For Best Deal*****************");
		 * System.out.println(result1.get(i).getText());
		 * System.out.println("****************************"); }
		 * 
		 * List<WebElement> cheapest = driver.findElements(By.xpath(
		 * "//div[@id='searchResultsList']/div/div[2]/div/div/div[1]")); for (int k=0;
		 * k<1; k++) { System.out.println("For Cheapest Deal******************");
		 * System.out.println(cheapest.get(k).getText());
		 * System.out.println("*****************************");
		 */
	}

}
