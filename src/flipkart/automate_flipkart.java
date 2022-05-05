package flipkart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class automate_flipkart {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/Subrat2022/SELENIUM/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Logging in:
		System.out.println("Flipkart log in");
		driver.findElement(By.xpath("//input [@class = \"_2IX_2- VJZDxU\"]")).sendKeys("8249387853");
		driver.findElement(By.xpath("//input [@type= \"password\"]")).sendKeys("Subrat@1598");
		driver.findElement(By.cssSelector("button[type= 'submit'] span")).click();
		System.out.println("Login success");
		
		//Search apple phones
//		driver.findElement(By.cssSelector("input[class = '_3704LK']")).sendKeys("apple");
//		driver.findElement(By.cssSelector("input[class = '_3704LK']")).click();
//		driver.findElement(By.xpath("//div[normalize-space()='APPLE iPhone 12 Mini (Black, 64 GB)']")).click();
		
		
		

	}

}
