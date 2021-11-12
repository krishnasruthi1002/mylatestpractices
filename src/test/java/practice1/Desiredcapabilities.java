package practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Desiredcapabilities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DesiredCapabilities ch= DesiredCapabilities.chrome();
		//this is to accept all kind of certifications
		ch.acceptInsecureCerts();
		//this is specify the certifications
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		ChromeOptions c= new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);
		
		
		//if we delete the session log cookie then the webpage should logout and should bring the loginpage
		driver.manage().deleteCookieNamed("sessionkey");;

	}

}
