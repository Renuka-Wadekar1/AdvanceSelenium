package GenericUtilities;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This class consists of generic methods related to selenium tool
 * 
 */
public class SeleniumUtility {
  /*
   * This method maximize windows
   * @param driver
   */
	
	 public void MaxmiseWindow(WebDriver driver) {
		 driver.manage().window().maximize();
	 }
	 
	 /*
	  * This method minimize window
	  *  @param driver
	  */
	 
	 public void MinimiseWindow(WebDriver driver) {
		 driver.manage().window().minimize();
	 }
	 
	 /*
	  * This method is to add Implicit wait
	  *  @param driver
	  */
	 
	 public void AddImplicitylyWait(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 }
	 /*
	  * This method will wait for 10 seconds for element to be visible
	  *  @param driver
	  *  @param element
	  */
	 public void waitForElementToBeVisible(WebDriver driver, WebElement element){
		 
		 WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(15));
		 w.until(ExpectedConditions.visibilityOf(element));
		 
	 }
	 
	 /*
	  * This method will wait for 10 seconds for element to be clickable  
	  *  @param driver
	  *  @param element
	  */
	 
      public void waitForElementToBeCliclable(WebDriver driver, WebElement element){
		 
		 WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(15));
		 w.until(ExpectedConditions.elementToBeClickable(element));
		 
	 }
      
      /*
 	  * This method will handdle dropdown by index
 	  *  @param driver
 	  *  @param element
 	  */
      public void handdelDropdown(WebElement element, int index ) {
    	  Select s=new Select(element);
    	  s.selectByIndex(index);
    	  
      }
      /*
  	  * This method will handdle dropdown by Text
  	  *  @param driver
  	  *  @param Text
  	  */
      public void handdelDropdownbyText(WebElement element, String Text ) {
    	  Select s=new Select(element);
    	  s.selectByVisibleText(Text);
    	  
      }
      /*
   	  * This method will handdle dropdown by value
   	  *  @param driver
   	  *  @param element
   	  */
       public void handdelDropdownBy(WebElement element, String Value ) {
     	  Select s=new Select(element);
     	  s.selectByValue(Value);
     	  
       }
       /*
     	  * This method perform action click and hold
     	  *  @param driver
     	  *  @param element
     	  */
       public void clickAndHold(WebDriver driver, WebElement element){
    	   Actions action =new Actions(driver);
   		   action.clickAndHold(element).perform();;
       }
       
       /*
   	  * This method perform action drag and drop
   	  *  @param driver
   	  *  @param element
   	  */
       public void dragAndDrop(WebDriver driver, WebElement element,WebElement TargetElement){
    	   Actions action =new Actions(driver);
   		   action.dragAndDrop(element, TargetElement).perform();;
       }
       
       /*
   	  * This method perform action mouseover
   	  *  @param driver
   	  *  @param element
   	  */
       public void MouseOver(WebDriver driver, WebElement element){
    	   Actions action =new Actions(driver);
   		action.moveToElement(element).perform();
       }
       /*
     	  * This method perform action scroll
     	  *  @param driver
     	  *  @param element
     	  */
         public void Scroll(WebDriver driver, WebElement element){
      	   Actions action =new Actions(driver);
     		action.scrollToElement(element).perform();;
         }
         /*
       	  * This method perform action doubleclick
       	  *  @param driver
       	  *  @param element
       	  */
           public void doubleclick(WebDriver driver, WebElement element){
        	   Actions action =new Actions(driver);
       		   action.doubleClick().perform();;
           }
           
           /*
            *  This method is used for frame handling with index
            *  @param driver
            *  @param Frameindex 
            */
           
           public void framHandleWithIndex(WebDriver driver, int Frameindex) {
       		driver.switchTo().frame(Frameindex);
      	 } 
           /*
            *  This method is used for frame handling with name or id
            *  @param driver
            *  @param Frameindex 
            */
           
           public void framHandlewithNameOrID(WebDriver driver, String framenameorid) {
       		driver.switchTo().frame(framenameorid);
      	 } 
           /*
            *  This method is used for frame handling with name or id
            *  @param driver
            *  @param Frameindex 
            */
           
           public void framHandleWithWebElement(WebDriver driver, WebElement framelement) {
       		driver.switchTo().frame(framelement);
      	 } 
           
           /*
            *  This method is used for alert handling with Accept
            *  @param driver     
            */
           public void acceptAlert(WebDriver driver) {
          		driver.switchTo().alert().accept();
         	 }
           /*
            *  This method is used to dismiss alert popup
            *  @param driver     
            */
           public void dismissAlert(WebDriver driver) {
          	 driver.switchTo().alert().dismiss();
         	 }
           
           /*
            *  This method is used to enter text in alert popup
            *  @param driver     
            */
           public void enterAlertText(WebDriver driver, String Text ) {
          		driver.switchTo().alert().sendKeys(Text);
         	 }
           
           /*
            *  This method is used to get alert text
            *  @param driver     
            */
           public String getAlertText(WebDriver driver ) {
         	 return driver.switchTo().alert().getText();
        	 }
           
           /*
            *  This method is used to switch from one window to other
            *  @param driver 
            *  @param windowId   
            */
           public void handleWindow(WebDriver driver, String windowId) {
       			driver.switchTo().window(windowId);	
        	 }
           
   
      
      /*
  	  * This method will takescreenshot of web page
  	  *  @param driver
  	  *  @param element
  	  */
       public String capturScreenshot(WebDriver driver, String ScreenshotName) throws IOException{
    	   TakesScreenshot ts = (TakesScreenshot)driver;
   		 File src = ts.getScreenshotAs(OutputType.FILE);
   		File dst=new File(".\\Screenshots\\"+ScreenshotName+".png");
   		FileHandler.copy(src, dst);
   		
   		return dst.getAbsolutePath(); //for extend report
  	 }

      

	 
	 
	 
}
