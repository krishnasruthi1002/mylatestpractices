package practice1;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTablesExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// for webpage to scroll to locate the below element
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000;");

		
		List<WebElement> values= driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]"));
		
		int sum= 0;
		for (int i=0;i<values.size();i++) {	
			// Integer.parseInt is used to convert text to integer value
			sum= sum + Integer.parseInt(values.get(i).getText());
		}
		
	String totalamount=	driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
	System.out.println(totalamount);
	
	String[] matches= totalamount.split(":");
	String amount= matches[1].trim();
	System.out.println(amount);
	int totalamountvalue= Integer.parseInt(amount);
	//we can use asserttrue,assertfail also
	//Assert.assertEquals(sum, totalamountvalue);
	if(sum==totalamountvalue) {
		System.out.println("count is matching");
		
	}
	else {
		System.out.println("count is not macthing");
	}
	}

}
