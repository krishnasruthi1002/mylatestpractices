package practice1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseoverAndFrames {
	WebDriver driver = new ChromeDriver();
	Actions a = new Actions(driver);
	
	public void mouseover() {
	

		
		driver.get("https://www.amazon.com/");
		
		//to perform any mouseover actions
		//we can use offset values also
		
		WebElement element = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		a.moveToElement(element).build().perform();
		// to right click
		a.moveToElement(element).contextClick().perform();
		
		//to write in capital letters
		WebElement type= driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
		a.moveToElement(type).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		
		//to select the written text
		a.moveToElement(type).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().perform();
		
		
	}
	
	
	public void windowshandle( ) {
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		//we have to know how many windows are opened and then switch from parent to child
		Set<String> window= driver.getWindowHandles();
	Iterator<String>	it =window.iterator();
	String parentid= it.next();
	String childid=it.next();
	
		driver.switchTo().window(childid);
		String paragraph= driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		System.out.println(paragraph);
		String[] split1= paragraph.split("at");
		
		String[] split2= split1[1].trim().split("with");
	 String mailid =split2[0].trim();
	 System.out.println(mailid);
		
	 driver.switchTo().window(parentid);
	 driver.findElement(By.xpath("//input[@id='username']")).sendKeys(mailid);
	}
	
	
	
	public void frames() {
		
		driver.get("https://jqueryui.com/droppable/");
		
		
		int count = driver.findElements(By.tagName("iframe")).size();
		System.out.println(count);
		
		//this is by using the  index value to go to frame
		//driver.switchTo().frame(0);
		
		//this is for using the webelement to switch to frames
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
	
		driver.findElement(By.xpath("//div[@id='draggable']")).click();
		WebElement source= driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target= driver.findElement(By.xpath("//div[@id='droppable']"));
		a.dragAndDrop(source, target).build().perform();
		//if we want to use offset values
		//a.dragAndDropBy(source, x offset value, y offset value);
		
		//to come back from i frame
		driver.switchTo().defaultContent();
		
	}
	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");
		MouseoverAndFrames m = new MouseoverAndFrames();
		m.frames();

	}

}
