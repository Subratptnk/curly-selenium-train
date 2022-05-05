package indigo_airlines;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Indigo_Airlines {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Subrat2022/SELENIUM/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goindigo.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	//Searching the source location.
		driver.findElement(By.xpath("//input[@class = \"form-control or-src-city\"]")).clear(); 
		System.out.println("Source location field got cleared");
		driver.findElement(By.xpath("//input[@class = \"form-control or-src-city\"]")).sendKeys("Bhub");
		System.out.println("Send the 3 letters to fin teh source city");
	//	List<WebElement> options = driver.findElements(By.cssSelector("div[class = \"wrap\"] div"));
		List<WebElement> options = driver.findElements(By.xpath("//div[@class = \"wrap\"]//div[@class = \"autocomplete-result station-result clearfix airport-item selected\"]//div[text() = \"BBI\"]"));
		System.out.println("Seach elements related to our source city");
	//	List<WebElement> options = driver.findElements(By.xpath("//div[@class='ig-input-group field-float']//div[@class='autocomplete-result station-result clearfix airport-item selected']"));
			
		for(WebElement option : options) {
			
			System.out.println(option.getText());
			if(option.getText().equalsIgnoreCase("BBI")) {
				option.click();
				System.out.println("Click performed");
				break;
			}
		}
		System.out.println("Source : For loop completes");
		Thread.sleep(1000);
		//Seaching the destination location
		driver.findElement(By.xpath("//input[@name='or-dest']")).sendKeys("DEL");
		System.out.println("Send the 3 letters to fin teh destination city");
		List<WebElement> destOptions = driver.findElements(By.cssSelector("div[class = \"wrap\"] div"));
		System.out.println("Seach elements related to our destination city");
		Thread.sleep(1000);
		for(WebElement option : destOptions) {
			if(option.getText().equalsIgnoreCase("Delhi, India "));
			System.out.println(option.getText());
			option.click();
			System.out.println("Clicked performed");
			break;
		}
		System.out.println("Destination : For loop completes");
		
		
		
	}

}
