package practice1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {
	WebDriver driver = new ChromeDriver();

	public void links() throws InterruptedException {

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		// links on entire page
		int count = driver.findElements(By.tagName("a")).size();
		System.out.println(count);
		// links on footer page
		// limiting the webdriver scope here the webdriver focuses only on footer
		// section as we are limiting it
		WebElement footdriver = driver
				.findElement(By.cssSelector("div[class=' footer_top_agile_w3ls gffoot footer_style']"));
		int footcount = footdriver.findElements(By.tagName("a")).size();
		System.out.println(footcount);
		// count of first column in footer section
		WebElement columndriver = footdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int columnCpount = columndriver.findElements(By.tagName("a")).size();
		
		
		System.out.println(columnCpount);
		// click on each link in the column if the pages are working
		// in this example 0th link is not working so using i=1
		for (int i = 0; i < columndriver.findElements(By.tagName("a")).size(); i++) {

			String clickonlink = Keys.chord(Keys.CONTROL, Keys.ENTER);// this is to click control and enter to open the
																		// link on the newwindow
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);

			Thread.sleep(4000L);
		}
			// wrapping everything in while and printing the title
			Set<String> links = driver.getWindowHandles();
			Iterator<String> it = links.iterator();
	
			//has next will check whther it is present or not and next will go and click to the next tab
			while (it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}

		}

	

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");
		Links l = new Links();
		l.links();
	}

}
