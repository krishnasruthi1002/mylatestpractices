package testNG;

import java.io.ObjectInputStream.GetField;
import java.util.List;
import org.apache.logging.log4j.*;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import logs.LogsExample;

public class AmazonPractice  {
	WebDriver driver;
	String name;
	private static Logger log= LogManager.getLogger(LogsExample.class.getName());
	
	@Parameters({ "URL1" })
	@BeforeTest
	public void logintoHomePage(String urlname1) {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(urlname1);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test( priority = -1)
	public void clickonSignInOption() {
		Actions a = new Actions(driver);
		WebElement signinbutton = driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]"));
		a.moveToElement(signinbutton).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id=\"nav-flyout-ya-signin\"]/a/span[@class=\"nav-action-inner\"]")).click();

	}

	@Test(dataProvider = "loginWithCredentials", priority = 0)
	public void loginToWelcomePage(String username, String password) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id=\"ap_email\"]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"ap_password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id=\"signInSubmit\"]")).click();
		String[] values = username.split("reddy");
		name = values[1];
		log.info("I wll give info");
		log.error(getClass());

	}

	@DataProvider
	public Object[][] loginWithCredentials() {
		// this is a multidimentional array indicatesthat it is having 2 rows and 2
		// columns
		Object[][] credentials = new Object[2][2];
		credentials[0][0] = "sruthireddy629@gmail.com";
		credentials[0][1] = "Ammulu@1002";
		
		
		return credentials;
	}

	@Test(priority = 1, enabled = false)
	public void checktheErrorMessege() {
		String actualmsg = driver
				.findElement(By.xpath("//div[@id=\"auth-error-message-box\"] //span[@class=\"a-list-item\"]"))
				.getText();
		String expectedmsg = "Your password is incorrect";
		Assert.assertEquals(actualmsg, expectedmsg);
		System.out.println(actualmsg);
	}

	@Test(priority = 2)
	public void chekWelcomemsg() {
		String actualwelcomemsg = driver.findElement(By.xpath("//span[@id=\"nav-link-accountList-nav-line-1\"]"))
				.getText();
		String[] expectedwelcomemsg = { "Hello, " + name };
		// Assert.assertEquals(actualwelcomemsg, expectedwelcomemsg);
		System.out.println(actualwelcomemsg);

	}

	@Test(priority = 3)
	public void allmenubutton() {
		driver.findElement(By.xpath("//a[@id=\"nav-hamburger-menu\"]")).click();
	}

	@Test(groups={"compuetrs"})
	public void computerslink() {
		driver.findElement(By.xpath("//a[@class=\"hmenu-item\"] /div[text()='Computers']")).click();
		driver.findElement(By.xpath("//a[text()='Computer Components']")).click();
		List<WebElement> allparts = driver
				.findElements(By.xpath("//span[@class=\"a-size-base a-color-base a-text-normal\"]"));
		for (int i = 0; i < allparts.size(); i++) {
			String partname= allparts.get(i).getText();
			if(partname.contains("Seagate Portable")) {
				System.out.println(partname);
				break;
			}
		}

	}
	
	@Test(groups={"compuetrs"})
	public void computersAndTables() {
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@id=\"nav-hamburger-menu\"]")).click();
		driver.findElement(By.xpath("//a[@class=\"hmenu-item\"] /div[text()='Computers']")).click();
		driver.findElement(By.xpath("//a[text()='Computers & Tablets']")).click();
		
	}

	
	@Test(priority = 6,groups={"arts"})
	public void arts() {
		driver.findElement(By.xpath("//div[text()='Arts & Crafts']")).click();
	}
}
