package practice1;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebTableExample1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        driver.get("https://demoqa.com/webtables");
        
       String value =  driver.findElement(By.className("rt-resizable-header-content")).getText();
       System.out.println(value);
        
       //get no of rows
       List<WebElement> rows=driver.findElements(By.className("rt-tr-group"));
       System.out.println("Total no of rows are: "+rows.size());
       
       //get rows which has data
       List<WebElement> rowsWithData=driver.findElements(By.xpath("//div[@class='rt-td' and text()]/ancestor::div[@class='rt-tr-group']"));
       System.out.println("Total no of rows with Data are: "+rowsWithData.size());
       
       System.out.println("Data of 2nd row: "+rowsWithData.get(1).getText()); //prints 2nd row
       
       //For Columns
       List<WebElement> colsWithData=driver.findElements(By.xpath("//div[@class='rt-td' and text()][2]"));
       System.out.println("Data in the 2nd Column");
       for(int i=0;i<colsWithData.size();i++) {
    	   System.out.println(colsWithData.get(i).getText());
       }
       
       //Dynamic Table
       driver.findElement(By.id("searchBox")).sendKeys("Alden");
       List<WebElement> rowsWithData2=driver.findElements(By.xpath("//div[@class='rt-td' and text()]/ancestor::div[@class='rt-tr-group']"));
       System.out.println("No of rows after the search: "+rowsWithData2.size());
       
	}

}
