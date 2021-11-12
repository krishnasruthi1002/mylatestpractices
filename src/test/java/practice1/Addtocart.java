package practice1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Addtocart {
	WebDriver driver = new ChromeDriver();

	public void addCart() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		int j = 0;
		String[] itemsNeeded = { "Cucumber", "Brocolli" };
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedname = name[0].trim();
			// format it to get actual name which is in ui
			// convert array to arraylist of itemsNeeded

			List s1 = Arrays.asList(itemsNeeded);
			if (s1.contains(formattedname)) {

				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// we are using this condition to run the for loop how many items are there in
				// the
				// items needed that many times only it should run for the loop later it should
				// break
				if (j == itemsNeeded.length)
					break;
			}

		}

		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		//explicit wait we use for particular element only
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
		
		String msg = driver.findElement(By.cssSelector("span[class='promoInfo']")).getText();
		System.out.println(msg);
		
	}

	
	
		
		
		
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");

		Addtocart d = new Addtocart();
		d.addCart();

	}

}
