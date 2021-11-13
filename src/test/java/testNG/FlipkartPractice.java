package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class FlipkartPractice {
	WebDriver driver;
	
	@Parameters({ "URL" })
	@BeforeTest
	public void logintoHomePage(String urlname) {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(urlname);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}

}
	