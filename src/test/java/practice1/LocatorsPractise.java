package practice1;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class LocatorsPractise {
	
	WebDriver driver = new ChromeDriver();
	
	public void locators1() throws InterruptedException {
		
driver.get("https://rahulshettyacademy.com/locatorspractice/");
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//using string to check the same name is printing or not in welcome page
		String name = "sruthi";
		driver.findElement(By.id("inputUsername")).sendKeys("sruthi");
		driver.findElement(By.name("inputPassword")).sendKeys("MMM");
		driver.findElement(By.className("signInBtn")).click();

	
String errorMessege = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errorMessege);
driver.findElement(By.linkText("Forgot your password?")).click();
driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("chinni");
driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Reddy");
driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("Krishna");
driver.findElement(By.xpath("//form/input[3]")).sendKeys("33366");
//driver.findElement(By.xpath("//div/button[2]")).click();
driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
String PasswrordText = driver.findElement(By.cssSelector("form p")).getText();
System.out.println(PasswrordText);

//using split method to get password dynamically
String[] passwordToEnter=PasswrordText.split("'");
String[] passwordToEnter1= passwordToEnter[1].split("'");


driver.findElement(By.xpath("//button[contains(@class,'go-to')]")).click();
Thread.sleep(5000);
driver.findElement(By.cssSelector("input[placeholder*='User']")).sendKeys("name");
driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(passwordToEnter1[0]);
driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();



		
	//assertions to check the displayed messeges
		String actualmessge = driver.findElement(By.xpath("//p")).getText();
		String expectedmessege = "You are successfully logged in.";
		String actualmessge1 = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
		String expectedmessege2 = "Hello "+name+",";

		Assert.assertEquals(actualmessge,expectedmessege);
		
		
	}
	
	
	public void locators2() {
		
		//siblings-parent traverse
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click();
		driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a")).click();
		
		//navigate commands
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().back();
	}
	

	public static void main(String[] args) throws InterruptedException   {
		System.setProperty("webdriver.chrome.driver","D:\\selenium workspace\\chromedriver.exe");
		LocatorsPractise loc = new LocatorsPractise();
		loc.locators2();
		
		
		




	
	}

}
