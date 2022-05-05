package phptravels;

import java.time.Duration;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PhpTravels {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/Subrat2022/SELENIUM/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//login in:
		
		System.out.println("Login to the site");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("user@phptravels.com");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("demouser");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//label[normalize-space()='Remember Me']")).click();
		Thread.sleep(5000);
		//add a scroll function
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']")).click();
		
		if(driver.findElement(By.xpath("//h2[contains(text(),'Hi,')]")) != null) {
			System.out.println("Login sucess");
		}
		
		
		// hotel bookings
		System.out.println("Hotel booking process");
		driver.findElement(By.linkText("Hotels")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("span[class='select2-selection__rendered']")).click();
		driver.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys("Bang");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("ul[class='select2-results__options'] li"));
		//driver.findElement(By.xpath("//ul[@id = \"select2-hotels_city-results\"]//li"));
		
		for(WebElement option : options) {
			if(option.getText().contains("Bangalore")) {
				option.click();
				System.out.println(" bangalore is found");
				break;
			}
		}
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@class='checkin form-control form-control-lg border-top-r0']")).click();
		driver.findElement(By.xpath("//tbody//td[text() = '27']")).click();
		driver.findElement(By.xpath("//td[contains(@class,'active')][normalize-space()='28']")).click();
		
		System.out.println("Dates are selected");
	/*
		driver.findElement(By.xpath("//a[@class='dropdown-toggle dropdown-btn travellers waves-effect']")).click();
		//adding 3 adults
		for(int i = 0; i< 3;i++) {
			driver.findElement(By.xpath("(//i[@class='la la-plus'])[3]")).click();
			System.out.println("Adults were selected");
		}
		
		WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='nationality']"));
		Select dropdown = new Select(countryDropdown);
		dropdown.selectByVisibleText("India");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
	*/	
		driver.findElement(By.cssSelector("button[class = 'btn btn-primary btn-block btn-lg effect ladda-button waves-effect']")).click();
		System.out.println("Hotel Searching");
		
		
		/*
		 * System.out.println("Quitting the browser"); driver.quit();
		 */
		
		//selecting hotels
		
		Thread.sleep(5000);
	//	driver.findElement(By.className("cc-btn cc-dismiss waves-effect")).click();
	//	Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='stars_2']")).click();
		List<WebElement> nameOfHotels = driver.findElements(By.xpath("//li[@class='mix stars_2 hotels_amenities_']//h3"));
		for(WebElement names : nameOfHotels) {
			System.out.println(names.getText());
			if(names.getText().equalsIgnoreCase("SPOT ON 48822 Balaji Residency")) {
				driver.findElement(By.xpath("//li[@id='spot on 48822 balaji residency']//a[contains(.,'Details')]")).click();
				System.out.println("Selected: SPOT ON 48822 Balaji Residency");
				break;
			}
		System.out.println("Not found");
			
		}
		

	}

}
