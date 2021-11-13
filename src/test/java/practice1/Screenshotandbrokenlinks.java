package practice1;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class Screenshotandbrokenlinks {
	WebDriver driver = new ChromeDriver();
	public void screenshot() throws IOException {

		driver.get("http://google.com");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// if we are unable to import the fileutils from selenium download the jars from
		// https://commons.apache.org/proper/commons-io/
		//FileUtils.copyFile(src, new File("D://selenium workspace"));
//if we give c driver path we need access don't prefer c, if only in c go to users
	}
	
	
	public void brokenlinks() throws MalformedURLException, IOException {
		//broken link means broken url is not working
		//java methods will call the urls and get the status code
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		

///iterate throgh footer and get all the status code and fail the test case if any broken links are there
		
List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

SoftAssert a = new SoftAssert();
for(WebElement link:links) {
	
	String url = link.getAttribute("href");
	HttpURLConnection conn= (HttpURLConnection) new  URL(url).openConnection();
	conn.setRequestMethod("HEAD");
conn.connect();
int responsecodes= conn.getResponseCode();
System.out.println(responsecodes);
String msg= "The link with Text"+link.getText()+" is broken with code"+responsecodes;
a.assertTrue(responsecodes<400, msg);

}
		
a.assertAll();		
		
		
		
		
	}

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");
		
		Screenshotandbrokenlinks sb = new Screenshotandbrokenlinks();
		sb.brokenlinks();

	}

}
