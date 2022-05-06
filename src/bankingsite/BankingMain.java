package bankingsite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BankingMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Subrat2022/SELENIUM/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/");
		driver.manage().window().maximize();
		
		  //finding the Register button 
		WebElement registerBtn =driver.findElement(By.xpath("//a[text() = 'Register']"));
		  registerBtn.click(); // Reading and updating the registration form:
		  
		  WebElement firstName =
		  driver.findElement(By.cssSelector("input[id='customer.firstName']"));
		  WebElement lastName =
		  driver.findElement(By.cssSelector("input[id='customer.lastName']"));
		  WebElement address =
		  driver.findElement(By.cssSelector("input[name='customer.address.street']"));
		  WebElement city = driver.findElement(By.id("customer.address.city"));
		  WebElement state = driver.findElement(By.name("customer.address.state"));
		  WebElement zipcode =
		  driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
		  WebElement phoneNumber =
		  driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"));
		  WebElement ssn =
		  driver.findElement(By.cssSelector("input[id='customer.ssn']"));
		  
		  WebElement username = driver.findElement(By.id("customer.username"));
		  WebElement password = driver.findElement(By.name("customer.password"));
		  WebElement confirm = driver.findElement(By.id("repeatedPassword"));
		  
		  firstName.sendKeys("Sanjeev"); lastName.sendKeys("Reddy");
		  address.sendKeys("B-15,padmanavam enclave"); city.sendKeys("Chennai");
		  state.sendKeys("Tamil Nadu"); zipcode.sendKeys("1100223");
		  phoneNumber.sendKeys("9978652076"); ssn.sendKeys("000001");
		  
		  username.sendKeys("Sanjeev1022"); 
		  password.sendKeys("Sanjeev@1001");
		  confirm.sendKeys("Sanjeev@1001");
		  
		  
		  WebElement clickRegister =
		  driver.findElement(By.xpath("//input[@value='Register']"));
		  clickRegister.click();
		 

		// WebElement errorText = driver.findElement(By.xpath("//p[tex[text()='An
		// internal error has occurred and has been logged.']]"));

		WebElement successText = driver
				.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));
		if (successText.getText().equalsIgnoreCase("An internal error has occurred and has been logged.")) {
			System.out.println("test cases failed");
		} else {
			System.out.println("test cases passed");

			System.out.println(successText.getText());
		}

		/*
		 * driver.findElement(By.xpath("//input[@name='username']")).sendKeys(
		 * "Sanjeev1002");
		 * driver.findElement(By.xpath("//input[@name='password']")).sendKeys(
		 * "Sanjeev@1001");
		 * 
		 * File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(src, new
		 * File("D:/Subrat2022/SELENIUM/Screenshots/bankSS03.png"));
		 * 
		 * driver.findElement(By.xpath("//input[@value='Log In']")).click();
		 * 
		 */

		driver.findElement(By.xpath("//a[text()='Accounts Overview']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String total = driver.findElement(By.xpath("(//td)[5]")).getText();

		System.out.println("Total balance is " + total);

		// driver.findElement(By.xpath("//a[text()='14010']")).click();
		driver.findElement(By.xpath("//a[text()='Open New Account']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement accounttypeDropdown = driver.findElement(By.xpath("//select[@id='type']"));
		Select dropdown = new Select(accounttypeDropdown);
		dropdown.selectByVisibleText("SAVINGS");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("D:/Subrat2022/SELENIUM/Screenshots/bankSS02.png"));
		
		driver.findElement(By.xpath("//input[@class='button']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String SucText = "Congratulations, your account is now open.";
		WebElement passText = driver
				.findElement(By.xpath("//p[normalize-space()='Congratulations, your account is now open.']"));

		File src2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src2, new File("D:/Subrat2022/SELENIUM/Screenshots/bankSS01.png"));

		String recivedText = passText.getText();

		if (recivedText.equalsIgnoreCase(SucText)) {
			System.out.println("Second Test case passed");
			String newId = driver.findElement(By.xpath("//a[@id='newAccountId']")).getText();
			System.out.println("New Account Number is " + newId);
			
		} 
		else {
			System.out.println("2nd test case failed");
			System.out.println("Try again!!!");
		}
		driver.findElement(By.xpath("//a[normalize-space()='Accounts Overview']")).click();
		
		
		// Transfer fund:
		
		WebElement transferFund = driver.findElement(By.xpath("//a[normalize-space()='Transfer Funds']"));
		transferFund.click();
		WebElement fromAcc = driver.findElement(By.xpath("//select[@id='fromAccountId']"));
		WebElement toAcc = driver.findElement(By.xpath("//select[@id='toAccountId']"));
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Select fromDropSelect = new Select(fromAcc);
		fromDropSelect.selectByIndex(1);
		
		Select toDropSelect = new Select(toAcc);
		toDropSelect.selectByIndex(2);
		
		WebElement amount = driver.findElement(By.id("amount"));
		amount.sendKeys("150");
		
		File src3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src3, new File("D:/Subrat2022/SELENIUM/Screenshots/bankSS04.png"));
		
		driver.findElement(By.xpath("//input[@value='Transfer']")).click();
		
		String message = driver.findElement(By.xpath("//p[contains(.,'$150.00 has been transferred from account #13566 to account #13566.')]")).getText();
		
		Assert.assertEquals(message,"$150.00 has been transferred from account #13566 to account #13566.");
		
		File src4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src4, new File("D:/Subrat2022/SELENIUM/Screenshots/bankSS05.png"));
		
	}

}
