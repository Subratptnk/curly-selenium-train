package bankingsite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BankingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Subrat2022/SELENIUM/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/");
		
		//finding the Register button
		WebElement registerBtn = driver.findElement(By.xpath("//a[text() = 'Register']"));
		registerBtn.click();
		// Reading and updating the registration form:
		
		WebElement firstName = driver.findElement(By.cssSelector("input[id='customer.firstName']"));
		WebElement lastName = driver.findElement(By.cssSelector("input[id='customer.lastName']"));
		WebElement address = driver.findElement(By.cssSelector("input[name='customer.address.street']"));
		WebElement city = driver.findElement(By.id("customer.address.city"));
		WebElement state = driver.findElement(By.name("customer.address.state"));
		WebElement zipcode = driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
		WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"));
		WebElement ssn = driver.findElement(By.cssSelector("input[id='customer.ssn']"));
		
		WebElement username = driver.findElement(By.id("customer.username"));
		WebElement password = driver.findElement(By.name("customer.password"));
		WebElement confirm = driver.findElement(By.id("repeatedPassword"));
		
		firstName.sendKeys("Sanjeev");
		lastName.sendKeys("Reddy");
		address.sendKeys("B-15,padmanavam enclave");
		city.sendKeys("Chennai");
		state.sendKeys("Tamil Nadu");
		zipcode.sendKeys("1100223");
		phoneNumber.sendKeys("9978652076");
		ssn.sendKeys("000001");
		
		username.sendKeys("Sanjeev1006");
		password.sendKeys("Sanjeev@1001");
		confirm.sendKeys("Sanjeev@1001");
		
		
		WebElement clickRegister = driver.findElement(By.xpath("//input[@value='Register']"));
		clickRegister.click();
		
		//WebElement errorText = driver.findElement(By.xpath("//p[tex[text()='An internal error has occurred and has been logged.']]"));
		WebElement successText = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));
		if(successText.getText().equalsIgnoreCase("An internal error has occurred and has been logged.")){
			System.out.println("test cases failed");
		}
		else {
			System.out.println("test cases passed");
			
			System.out.println(successText.getText());
		}
		
		driver.findElement(By.xpath("//a[text()='Accounts Overview']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String total = driver.findElement(By.xpath("(//td)[5]")).getText();
		
		System.out.println("Total balance is "+total);
		
			
		/*
		 * // loggin in:
		 * driver.findElement(By.xpath("//input[@name='username']")).sendKeys(
		 * "Sanjeev1003");
		 * driver.findElement(By.xpath("//input[@name='password']")).sendKeys(
		 * "Sanjeev@1001");
		 * driver.findElement(By.xpath("//input[@value='Log In']")).click();
		 */
		
		
	}

}
