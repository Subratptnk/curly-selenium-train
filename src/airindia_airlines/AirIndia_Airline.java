package airindia_airlines;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AirIndia_Airline {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Subrat2022/SELENIUM/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.airindia.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//label[@for='oneway']")).click();
		System.out.println("one way -clicked");
		driver.findElement(By.cssSelector("input[id='from']")).sendKeys("Bhu");
		System.out.println("Autosuggestive - box found and searched Bhu");
		Thread.sleep(2000);
		List<WebElement> srcOptions = driver.findElements(By.cssSelector("li[class = 'ui-menu-item'] a"));
		
		System.out.println("loop starts");
		for(WebElement option : srcOptions) {
			System.out.println(option.getText());
			if(option.getText().equalsIgnoreCase("Bhubaneswar, Biju Patnaik Airport, BBI, India")) {
				option.click();
				System.out.println("bhubaneswar selected");
				break;
			}
		}
		
		System.out.println("Destination segment");
		driver.findElement(By.id("to")).sendKeys("dxb");
		System.out.println("auto-search for Delhi");
		Thread.sleep(2000);
		List<WebElement> destOptions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		System.out.println("Destination loop starts");
		for(WebElement option : destOptions) {
			System.out.println(option.getText());
			
			  if(option.getText().equalsIgnoreCase("Dubai, Dubai International Airport, DXB, United Arab Emirates")) {
			  option.click(); System.out.println("Dubai selected"); 
			  break;
			  }
			 
		}
		System.out.println("Selecting the calender");
		driver.findElement(By.xpath("//div[@class='date alignLeft']//img[@title='Date Picker']")).click();
		System.out.println("Calender opens");
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active.ui-state-hover")).click();
		driver.findElement(By.cssSelector("label[for='rdrules1']")).click();
		System.out.println("Select the armed force dropdown");
		WebElement concessionaryType = driver.findElement(By.name("concessionaryType1"));
		Select dropdown = new Select(concessionaryType);
		dropdown.selectByIndex(5);
		System.out.println("Armed forced selected");
		System.out.println("Select the number of adults from dropdown");
		WebElement adultsNumber =driver.findElement(By.name("ddladult1"));
		Select adultSelect = new Select(adultsNumber);
		adultSelect.selectByIndex(3);
		System.out.println("Select the class dropdown");
		WebElement classType = driver.findElement(By.name("_classType1"));
		Select classSelect = new Select(classType);
		classSelect.selectByIndex(1);
		
		System.out.println("select the book now button");
		driver.findElement(By.id("btnbooking")).click();
		System.out.println("Execution completed");
		
	}

}
