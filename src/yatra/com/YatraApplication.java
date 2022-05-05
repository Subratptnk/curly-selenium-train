package yatra.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YatraApplication {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:/Subrat2022/SELENIUM/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();
		
		YatraApplication yatra = new YatraApplication();
		yatra.flightBooking(driver, wait);

	}
	
	
	
	public void flightBooking(WebDriver driver, WebDriverWait wait) {
	
		System.out.println("****Flight Booking****");
		driver.findElement(By.cssSelector("a[title='Round Trip']")).click();
		System.out.println("Clicked on Round trip --- 1");
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='BE_flight_origin_city']")));
		
		driver.findElement(By.xpath("//label[@for='BE_flight_origin_city']")).click();
		driver.findElement(By.xpath("//label[@for='BE_flight_origin_city']")).sendKeys("New");
		List<WebElement> cityList = driver.findElements(By.xpath("//div[@class='ac_results origin_ac']//li//p[@class='ac_cityname']"));
		
		for(WebElement city : cityList) {
			if(city.getText().equalsIgnoreCase("Bangalore")) {
				driver.findElement(By.xpath("(//p[@class='ac_cityname'])")).click();
				System.out.println(city.getText()+ "is clicked --- 3");
				break;
			}
		}
		
		// //li[@class='']//div//p[@class = 'ac_cityname']
	}
}
