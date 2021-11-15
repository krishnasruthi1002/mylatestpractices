package practice1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTablesSorting {
	WebDriver driver;

	@Test
	public void sorting() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		
		Set<String> window = driver.getWindowHandles();
		
		Iterator<String>	it =window.iterator();
		String parentid= it.next();
		String childid=it.next();
		
			driver.switchTo().window(childid);
		
		
			driver.findElement(By.xpath("//tr/th[1]")).click();
			
	}
	@Test(dependsOnMethods= {"sorting"})
	public void table() {
		driver.findElement(By.xpath("//table[@class='table table-bordered']"));
	String	 str= driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody/tr[2]")).getText();
	System.out.println(str);
	
	List<WebElement> names1=	driver.findElements(By.xpath("//tr/td[1]"));
	for(int i=0;i<names1.size();i++) {
		
		String vegnames =names1.get(i).getText();
		System.out.println(vegnames);
		
		//table[@class='table table-bordered']//tr/th[2]
		
		//table[@class='table table-bordered']//tbody/tr[2]
	}
	}
	
	
	
	
			//@Test(dependsOnMethods= {"sorting"})
			public void generalProcedure() {
	List<WebElement> names1=	driver.findElements(By.xpath("//tr/td[1]"));
	for(int i=0;i<names1.size();i++) {
		String vegnames =names1.get(i).getText();
		System.out.println(vegnames);
		
	}
	
	driver.findElement(By.xpath("//tr/th[1]")).click();
	List<WebElement> names11=	driver.findElements(By.xpath("//tr/td[1]"));
	for(int i=0;i<names11.size();i++) {
		String vegnames1 =names11.get(i).getText();
		System.out.println(vegnames1);
		if(vegnames1.equals("Strawberry")) {
			
			String value= driver.findElement(By.xpath(" //tr/td[1]/following-sibling::td[1]")).getText();
			System.out.println(value);
		}
		
	}
	List<WebElement> all= driver.findElements(By.xpath("//tr"));
	for(int i=0;i<all.size();i++) {
	String all1=	all.get(i).getText();
	System.out.println(all1);
	}
	}
			
			
		
			
			
			
			
			
			
			
			
			
	
//	@Test(dependsOnMethods={"sorting"})
	public void withstream() {
	
	List<WebElement> names=	driver.findElements(By.xpath("//tr/td[1]"));
	
	List<String> veg=	names.stream().map(s->s.getText()).collect(Collectors.toList());
	System.out.println(veg);
	List<String> sortedlist=	veg.stream().sorted().collect(Collectors.toList());
	System.out.println(sortedlist);
	

	
	


	
	Assert.assertTrue(veg.equals(sortedlist));
	}
	
}
