package practice1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//for webpage to scroll to locate the below element
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000;");
	
		
	}

}
