package practice1;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshotandbrokenlinks {
	WebDriver driver = new ChromeDriver();
	public void screenshot() {

		driver.get("http://google.com");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// if we are unable to import the fileutils from selenium download the jars from
		// https://commons.apache.org/proper/commons-io/
		//FileUtils.copyFile(src, new File("D://selenium workspace"));
//if we give c driver path we need access don't prefer c, if only in c go to users
	}
	
	public void brokenlinks() {
		
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");
		

	}

}
