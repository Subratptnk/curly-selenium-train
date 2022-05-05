package bigbasket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigBasket_Auto {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Subrat2022/SELENIUM/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		
		//Login process
		
		System.out.println("Login Process");
		driver.findElement(By.xpath("//a[@ng-click=\"vm.openLoginAndSignupModal('login')\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#otpEmail")).sendKeys("8249387853");
		driver.findElement(By.cssSelector(".btn.btn-default.login-btn")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.cssSelector(".btn.btn-default.btn-lg.login-btn.fixed-btn")).click();
		
	}

}
