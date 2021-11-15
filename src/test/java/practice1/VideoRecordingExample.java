package practice1;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.net.MediaType;



public class VideoRecordingExample {
	

		   private static ScreenRecorder screenRecorder;
		   
		   public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		      GraphicsConfiguration gconfig = GraphicsEnvironment
		         .getLocalGraphicsEnvironment()
		         .getDefaultScreenDevice()
		         .getDefaultConfiguration();
		      
		      screenRecorder = new ScreenRecorder(gconfig);
		      
		   //   WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");
		      WebDriver driver = new ChromeDriver();
		      
		      // Start Capturing the Video
		      screenRecorder.start();
		   
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      
		          driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
		          Thread.sleep(4000);
		          driver.findElement(By.name("username")).sendKeys("j2ee");
		          Thread.sleep(4000);
		          driver.findElement(By.name("password")).clear();
		          Thread.sleep(4000);
		          driver.findElement(By.name("password")).sendKeys("j2ee");
		          Thread.sleep(5000);
		          driver.findElement(By.name("signon")).click();

		      File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		      FileUtils.copyFile(screenshot, new File("D:\\screenshots\\screenshots1.jpg"));
		      
		      driver.close();
		      
		      // Stop the ScreenRecorder
		      screenRecorder.stop();
		   }
		}


