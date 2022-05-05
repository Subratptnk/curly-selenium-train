package parabank;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class ParaBank_Automation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Subrat2022/SELENIUM/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Drivers are up and running");
		
		// Register process
		
		 driver.findElement(By.xpath("//a[text() = \"Register\"]")).click();
		
		//form
		driver.findElement(By.xpath("//input[@name = \"customer.firstName\"]")).sendKeys("TestUser");
		driver.findElement(By.xpath("//input[@name = \"customer.lastName\"]")).sendKeys("01");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("House 14, Jaydhev vihar");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Bhubaneswar");
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("8987665091");
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys("765192");
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Odisha");
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("00001");
		driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys("TestUser05");
		driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("TestAuto05");
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("TestAuto05");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
		String siteName = driver.findElement(By.xpath("//h1[@class = \"title\"]")).getText();
		//Extract username
		String[] tempStore = siteName.split(" ");
		System.out.println(tempStore[1]);
		//takeScreenshot(driver);
		
		// Scenario 1 : Open new account 
		
		driver.findElement(By.xpath("//a[text()='Open New Account']")).click();
		
		
		
		
		
		
		
		
		
		
		//driver.findElement(By.xpath("//a[text()='Log Out']")).click();	
		

	}
	
	/*
	 * public static void takeScreenshot(WebDriver webdriver) throws IOException {
	 * Screenshot s=new
	 * AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).
	 * takeScreenshot(webdriver); ImageIO.write(s.getImage(),"PNG",new
	 * File("screen01.png")); }
	 */
	

}
