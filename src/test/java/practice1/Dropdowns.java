package practice1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {
	WebDriver driver = new ChromeDriver();

	public void dropdown() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		WebElement dropdowns = driver.findElement(By.xpath("//select[@name='ctl00$mainContent$DropDownListCurrency']"));
		Select dropdown = new Select(dropdowns);
		dropdown.selectByIndex(3);
		String s1 = dropdown.getFirstSelectedOption().getText();
		System.out.println(s1);
//dropdown.getAllSelectedOptions();
		dropdown.selectByVisibleText("INR");
		String s2 = dropdown.getFirstSelectedOption().getText();
		System.out.println(s2);
		dropdown.selectByValue("AED");
		String s3 = dropdown.getFirstSelectedOption().getText();
		System.out.println(s3);

	}

	public void dropdown2() throws InterruptedException {

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div/div[@id='divpaxinfo']")).click();

		// to click the child 5 times we have to use while loop
		// while loop will run infinite time if you don't give condition
		/*
		 * int i=1; while(i<5){
		 * driver.findElement(By.xpath("//div/span[@id='hrefIncChd']")).click(); i++;
		 * 
		 * }
		 */
		// we can also use for loop
		for (int i = 0; i < 3; i++) {
			driver.findElement(By.xpath("//div/span[@id='hrefIncChd']")).click();

		}
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		String m= driver.findElement(By.cssSelector("div[id='divpaxinfo']")).getText();
		System.out.println(m);
		driver.quit();
	}
	
	public void dropdown3() {
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
	}

	public void autosuggestive() throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("aus");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		//to iterate through the auto suggested drop downs and click on which we need to select
		for (WebElement option: options) {
			if(option.getText().equalsIgnoreCase("Australia")) {
				option.click();
				break;
				
			}
			
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");
		Dropdowns d = new Dropdowns();
		d.dropdown();

	}

}
