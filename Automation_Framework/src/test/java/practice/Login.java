package practice;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Login {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Read test data from file
		FileInputStream fsi=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties P=new Properties();
		P.load(fsi);
		String URL= P.getProperty("url");
		String USERNAME= P.getProperty("username");
		String PASSWORD= P.getProperty("password");
		
		//Read the data from Excel
		FileInputStream fsie=new FileInputStream(".\\src\\test\\resources\\Test Data.xlsx");
		Workbook wb = WorkbookFactory.create(fsie);
	    Sheet sh = wb.getSheetAt(0); // Get first sheet
	    Row row = sh.getRow(1);
	    Cell c=row.getCell(2);
	    String PRODUCTNAME = c.getStringCellValue();
	    System.out.println(PRODUCTNAME);
		WebDriver driver= new EdgeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		//Alert alert=driver.switchTo().alert();
		//alert.accept();
		 WebElement ele = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		 String productname = ele.getText();
		 ele.click();
		 
		driver.findElement(By.id("add-to-cart")).click();
		//driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		WebElement ele1 = driver.findElement(By.className("inventory_item_name"));
		String productname1=ele1.getText();

		 if(productname1.equals(productname))
			 System.out.println("pass");
		 else 
			 System.out.println("Fail");
		 driver.findElement(By.id("react-burger-menu-btn")).click();
		 driver.findElement(By.id("logout_sidebar_link")).click();
		 //driver.quit();
//		System.out.println(list.get(1).getText());
//		String actual="1\r\n"
//				+ "Sauce Labs Backpack\r\n"
//				+ "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\r\n"
//				+ "$29.99\r\n"
//				+ "Remove";
//		//assert.actual()
//		//assert(actual,expected);
//		driver.quit();
//		
//		

	}

}
