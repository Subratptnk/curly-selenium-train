package amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_Auto {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Subrat2022/SELENIUM/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/ref=ap_frn_logo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		//clicking to Sign in
		driver.findElement(By.cssSelector("span[id = 'nav-link-accountList-nav-line-1']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.cssSelector("span[class = 'nav-action-inner']")).click();
		driver.findElement(By.cssSelector("input[id = 'ap_email']")).sendKeys("8249387853");
		driver.findElement(By.cssSelector("input[id = 'continue']")).click();
		driver.findElement(By.cssSelector("input[id = 'ap_password']")).sendKeys("Subrat@1598");
		driver.findElement(By.cssSelector("input[name = 'rememberMe']")).click();
		driver.findElement(By.cssSelector("input[id = 'signInSubmit']")).click();
		String loginName = driver.findElement(By.cssSelector("span[id = 'nav-link-accountList-nav-line-1']")).getText();
		String[] userName = loginName.split(", ");
		System.out.println("You user-name is "+userName[1]);
		
		//seaching smart watches
		driver.findElement(By.cssSelector("input[id = \"twotabsearchtextbox\"]")).sendKeys("Smart Watch");
		driver.findElement(By.cssSelector("input[id = \"nav-search-submit-button\"]")).click();
		Thread.sleep(1000);
		//driver.findElement(By.cssSelector("span[class='s-rib-toggle aok-inline-block aok-align-center ']")).click();
		driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']")).click();
		System.out.println("Smart watch");
		Thread.sleep(2000);
		String price = driver.findElement(By.cssSelector("span[class='a-price aok-align-center priceToPay'] span[class='a-price-whole']")).getText();
		System.out.println("Price " +price);
		int quantity = 0;
		while(quantity < 3) {
			driver.findElement(By.xpath("//span[@id = \"increase-quantity-icon-action\"]")).click();
			quantity++;
		}
		driver.findElement(By.cssSelector("input[id='add-to-cart-button']")).click();
		String subtotal = driver.findElement(By.xpath("//div[@class = \"a-column a-span12\"]//span[@class = \"a-text-bold\"]")).getText();
		
		//
		
		System.out.println("subtotal "+subtotal);
		
		
		
	}

}
