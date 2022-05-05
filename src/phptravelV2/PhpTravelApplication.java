package phptravelV2;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class PhpTravelApplication {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Subrat2022/SELENIUM/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/login");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		loginProcess(driver, wait);
		flightSearch(driver, wait);
		flightSelection(driver,wait);
		
		

	}
	

	public static void loginProcess (WebDriver driver, WebDriverWait wait) throws InterruptedException {

		System.out.println("Login to the site");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("user@phptravels.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("demouser");
		driver.findElement(By.xpath("//label[contains(.,'Remember Me')]")).click();
		driver.manage().deleteAllCookies();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		System.out.println("Login Success");
		
	}

	public static void flightSearch(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		System.out.println("Flight search");
		driver.findElement(By.xpath("//a[text()='flights']")).click();
		driver.findElement(By.xpath("//label[@for='round-trip']")).click();
		System.out.println("Add the origin city");
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Del");
		List<WebElement> originCityList = driver.findElements(By.xpath("//div[@class = 'autocomplete-location']"));
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,250)", "");
		
		for(WebElement city : originCityList) {
			System.out.println(city.getText());
			String[] nameCity = city.getText().split(",");
			if(nameCity[0].equalsIgnoreCase("Delhi")) {
				driver.findElement(By.xpath("//strong[normalize-space()='Indira Gandhi Intl']")).click();
				System.out.println(nameCity[0]+" is Clicked");
				break;
			}
			else {
			System.out.println("Failure");
			}
		}
		
		System.out.println("Desination city");
		driver.findElement(By.xpath("//input[@id='autocomplete2']")).sendKeys("Mum");
		List<WebElement> destinationCityList = driver.findElements(By.xpath("//div[@class = 'autocomplete-location']"));
		
		for(WebElement city : destinationCityList) {
			String[] nameCity = city.getText().split(",");
			if(nameCity[0].equalsIgnoreCase("Mumbai")) {
				driver.findElement(By.xpath("//div[@class='autocomplete-location']")).click();
				System.out.println(nameCity[0]+" is clicked");
				break;
			}
 		}
		
		System.out.println("Selecting start date");
		driver.findElement(By.xpath("//input[@class='depart form-control dateleft border-top-r0']")).click();
		driver.findElement(By.xpath("//td[text() = '15']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[contains(@class,'active')][normalize-space()='16']")).click();
		System.out.println("Adding number of adults");
		driver.findElement(By.xpath("//a[@role='button']")).click();
		List<WebElement> passengers = driver.findElements(By.xpath("//div[@class='dropdown-item']//label"));
		for(WebElement people : passengers) {
		
			System.out.println(people.getText());
			if(people.getText().equalsIgnoreCase("adults")) {
				for(int i = 0; i<2;i++) {
				driver.findElement(By.xpath("//div[@class='qtyInc']")).click();
				System.out.println("Number of adults added is 3");
				}
				break;
			}
			else {
				System.out.println("Not selected passenger");
			}
		}
		driver.findElement(By.xpath("//button[@id='flights-search']")).click();
	}
	

	private static void flightSelection(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='breadcrumb-content']")));
		System.out.println("Wait over");
		System.out.println("Selecting a suitable flight");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		System.out.println("Show only air india");
		
		//driver.findElement(By.xpath("//label[normalize-space()='Air India']//img")).click();
		List<WebElement> priceOfFlight = driver.findElements(By.cssSelector("button[class='btn btn-primary btn-block theme-search-results-item-price-btn ladda waves-effect'] strong"));
		for(WebElement fare : priceOfFlight) {	
			String [] priceList = fare.getText().split("USD ");
			float price = Float.parseFloat(priceList[1]);
			System.out.println(price +"-- 2");
			if(price == 156.2 || price == 429  ) {
				driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block theme-search-results-item-price-btn ladda waves-effect']")).click();
				System.out.println("Button Clicked");
				break;
			}
		}
	}
}
