package search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	    driver=new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/index.php");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void searchByTennis() {
		driver.findElement(By.id("search_query_top")).sendKeys("tennis");
		driver.findElement(By.name("submit_search")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String textTypeOfResult = driver.findElement(By.className("heading-counter")).getText();
		System.out.println(textTypeOfResult);
	}
}
