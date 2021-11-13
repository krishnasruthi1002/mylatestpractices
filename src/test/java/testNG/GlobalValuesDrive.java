package testNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValuesDrive {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\selenium workspace\\Practise1\\data.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("browser"));
//this is to update the value in the file
		prop.setProperty("browser", "firefox");
		System.out.println(prop.getProperty("browser"));
//this is to get the updated information in the file
		FileOutputStream fos = new FileOutputStream("D:\\selenium workspace\\Practise1\\data.properties");
		prop.store(fos, null);

	}

}
