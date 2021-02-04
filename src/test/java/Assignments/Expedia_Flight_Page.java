package Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Expedia_Flight_Page {
	public static void main(String[] args) {
		test1();
	}
	public static void test1()  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.expedia.com/");
		List<WebElement> tabs = driver.findElements(By.xpath("//li[@class='uitk-tab uitk-tab-icon-text ']"));
		for (int i = 0; i < tabs.size(); i++) {
			String tabname = tabs.get(i).getText();
			if (tabname.contains("Flights")) {
				driver.findElements(By.xpath("//li[@class='uitk-tab uitk-tab-icon-text ']")).get(i).click();
				break;
			}
		}
		
		List<WebElement> way = driver.findElements(By.xpath("//li[@class='uitk-tab uitk-tab-button ']"));
		for (int h = 0; h < way.size(); h++) {
			String oneway = way.get(h).getText();
			if (oneway.contains("One-way")) {
				driver.findElement(By.xpath("//li[@class='uitk-tab uitk-tab-button ']")).click();
				break;
			}
		}
		driver.findElement(By.cssSelector("button[aria-label='Leaving from']")).sendKeys("JFK");
		List<WebElement> Origins = driver.findElements(By.cssSelector(
				"div[class='uitk-typeahead-button-label uitk-type-medium uitk-type-300 truncate'] div span strong"));
		for (WebElement origin : Origins) {
			if (origin.getText().contains("New York (JFK - John F. Kennedy Intl.)")) {
				origin.click();
				break;
			}
		}
		driver.findElement(By.xpath("//button[@aria-label='Going to']")).sendKeys("DHK");

		List<WebElement> Destinations = driver.findElements(
				By.xpath("//ul[@data-stid='location-field-leg1-destination-results']/li/button/div/div/span/strong"));

		for (WebElement destin : Destinations) {
			if (destin.getText().equalsIgnoreCase("Dhaka (DAC - Shahjalal Intl.)")) {
				destin.click();
			}
		}

		String month = "March 2021";
		driver.findElement(By.cssSelector("#d1-btn")).click();
		while (true) {
			String text = driver.findElement(By.xpath(
					"//*[@id=\"wizard-flight-tab-oneway\"]/div[2]/div[2]/div/div/div/div/div/div[2]/div/div[2]/div[2]/div[1]/h2"))
					.getText();
			if (text.equals(month)) {
				break;
			} else {
				driver.findElement(By.xpath(
						"//*[@id=\"wizard-flight-tab-oneway\"]/div[2]/div[2]/div/div/div/div/div/div[2]/div/div[2]/div[1]/button[2]"))
						.click();
			}
		}

		driver.findElement(By.xpath("//tbody/tr[3]/td[2]/button[@aria-label='Mar 15, 2021']")).click();
		driver.findElement(By.xpath("//a[@aria-label='1 traveler']")).click();

		for (int ad = 1; ad < 3; ad++) {
			driver.findElement(By.xpath("//*[@id='adaptive-menu']/div/div/section/div[1]/div[1]/div/button[2]"))
					.click();
		}

		for (int cl = 0; cl < 2; cl++) {
			driver.findElement(By.xpath("//*[@id='adaptive-menu']/div/div/section/div[1]/div[2]/div/button[2]"))
					.click();
		}
		WebElement Child1 = driver.findElement(By.cssSelector("#child-age-input-0-0"));
		Select cl1 = new Select(Child1);
		cl1.selectByValue("10");
		WebElement Child2 = driver.findElement(By.cssSelector("#child-age-input-0-1"));
		Select cl2 = new Select(Child2);
		cl2.selectByVisibleText("7");

		for (int in = 0; in < 1; in++) {
			driver.findElement(By.xpath("//*[@id='adaptive-menu']/div/div/section/div[1]/div[4]/div/button[2]"))
					.click();
		}
		WebElement Infant1 = driver.findElement(By.cssSelector("#infant-age-input-0-0"));
		Select in1 = new Select(Infant1);
		in1.selectByValue("0");
		System.out.println("On lap selected - " + driver.findElement(By.cssSelector("#ChildOnLap")).isSelected());
		driver.findElement(By.xpath("//button[@data-testid='guests-done-button']")).click();
		System.out.println(driver.findElement(By.cssSelector("a[data-testid='travelers-field']")).getText());

		driver.findElement(By.cssSelector("#preferred-class-input-trigger")).click();
		driver.findElement(By.xpath("//a[@class='uitk-list-item']/span[contains(text(),'Business class')]")).click();

		driver.findElement(By.cssSelector("button[data-testid='submit-button']")).click();
	}

}
