package testNG;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.*;
import logs.LogsExample;

public class FlipkartPractice {
	WebDriver driver;
	private static Logger log= LogManager.getLogger(LogsExample.class.getName());
	@Parameters({ "URL" })
	@BeforeTest
	public void logintoHomePage(String urlname) {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(urlname);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("I wll give info");
		log.error(getClass());
}

}
	