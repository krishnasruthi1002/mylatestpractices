package practice1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	WebDriver driver = new ChromeDriver();

	public void calendar1() {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']"))
				.click();

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
	}
	
	
	public void calenrdateandmonth() {
		
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();
		String n="23";
		String m="Feb";
		String k="2022";
		
		
		//to select the year 
		driver.findElement(By.xpath("//div[@class='datepicker-days'] //th[@class='datepicker-switch']")).click();
		//while loop always execute until the statement is false , for that ! if we give this the true statement becomes false and false statement becomes true
		while(!driver.findElement(By.xpath("//div[@class='datepicker-months'] //th[@class='datepicker-switch']")).getText().contains(k)) {
			driver.findElement(By.xpath("//div[@class='datepicker-months'] //th[@class='next']")).click();
		}
		
		//to select month
		int s= driver.findElements(By.xpath("//span[@class='month']")).size();
		for (int i=0;i<s;i++) {
			
		String	monthnamerequired= driver.findElements(By.xpath("//span[@class='month']")).get(i).getText();
		if(monthnamerequired.equalsIgnoreCase(m)) {
			
			driver.findElements(By.xpath("//span[@class='month']")).get(i).click();
		}
		}
		
		
		
		//this is to select the particular date
		List<WebElement> dates = driver.findElements(By.className("day"));
		int num= driver.findElements(By.className("day")).size();
		for (int i=0;i<num;i++) {
			String date=  driver.findElements(By.className("day")).get(i).getText();
			if(date.equalsIgnoreCase(n)) {
				 driver.findElements(By.className("day")).get(i).click();
				 break;
				 
			}
			
		}
		
		
		//for selecting the todays date we can go with xpath of todays date,because it will not change even the date is changed , todays date xpath will remain constant
	}
	public void alert() {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		String s= driver.switchTo().alert().getText();
		System.out.println(s);
		driver.switchTo().alert().accept();
		
		
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");

		Calendar c = new Calendar();
		c.calenrdateandmonth();
	}

}
