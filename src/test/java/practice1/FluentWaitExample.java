package practice1;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");

WebDriver driver = new ChromeDriver();
driver.get("https://the-internet.herokuapp.com/dynamic_loading");
driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
final WebElement text = driver.findElement(By.cssSelector("[id='finish'] h4"));


Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

WebElement foo= wait.until(new Function<WebDriver, WebElement>(){
	
	public WebElement apply(WebDriver driver) {
		if(text.isDisplayed()) {
			return text ;
		}
		else 
			return null;
	
	}
	
});
System.out.println(text.getText());
	}

}
