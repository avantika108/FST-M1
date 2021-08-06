import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Activity7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();

		driver.get("http://alchemy.hguy.co/crm");
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//*[@id=\'bigbutton\']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
          WebElement Sales=driver.findElement(By.id("grouptab_0"));
          Sales.click();
	      WebElement  SalesLeads= driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Leads\"]"));
	      SalesLeads.click();
	      Thread.sleep(3000);
	  
	      WebElement info =driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[2]/td[10]/span/span"));
		  info.click();
	
	       wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.phone:nth-child(8)")));
	       System.out.println("Mobile Phone details: "+driver.findElement(By.cssSelector("span.phone")).getText());
	        
	       WebElement Homephone=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.phone:nth-child(11)")));
	       System.out.println("Home Phone details: "+Homephone.getText());
	        
	       driver.close();
		
		
		
	}

}
