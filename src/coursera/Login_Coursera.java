package coursera;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Coursera {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Subrat2022/SELENIUM/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.coursera.org/in");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Execution starts");
		driver.findElement(By.xpath("//a[text() = \"Log In\"]")).click();
		driver.findElement(By.xpath("//input[@type = \"email\"]")).sendKeys("mrsubrat1998@gmail.com");
		driver.findElement(By.xpath("//input[@type = \"password\"]")).sendKeys("Subrat@1598");
		driver.findElement(By.xpath("//button[text() = \"Login\"]")).click();
		System.out.println("Login successful");
		
		Thread.sleep(2000);
		
		//print the username
		System.out.println(driver.findElement(By.xpath("//button[@id = \"right-nav-dropdown-btn\"]//span[@class = \"rc-UserPortrait__full-name body c-ph-username\"]")).getText());
		
		
		


	}

}
