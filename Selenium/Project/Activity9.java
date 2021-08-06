import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();

		driver.get("http://alchemy.hguy.co/crm");
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//*[@id=\'bigbutton\']")).click();
	    driver.findElement(By.id("grouptab_0")).click();
	    driver.findElement(By.id("moduleTab_9_Leads")).click();
	    
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    List <WebElement> tableRows= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='list view table-responsive']/tbody/tr"))) ;
	    
		System.out.println("Number of rows are: " + tableRows.size());
		
		int count =0 ;
		System.out.println("Names column:");
		System.out.println(tableRows.get(0).findElement(By.xpath("td[3]//a")).getText()); 	
		System.out.println(tableRows.get(1).findElement(By.xpath("td[3]//a")).getText()); 
		System.out.println(tableRows.get(2).findElement(By.xpath("td[3]//a")).getText()); 
		System.out.println(tableRows.get(3).findElement(By.xpath("td[3]//a")).getText()); 
		System.out.println(tableRows.get(4).findElement(By.xpath("td[3]//a")).getText()); 
		System.out.println(tableRows.get(5).findElement(By.xpath("td[3]//a")).getText()); 
		System.out.println(tableRows.get(6).findElement(By.xpath("td[3]//a")).getText()); 
		System.out.println(tableRows.get(7).findElement(By.xpath("td[3]//a")).getText()); 
		System.out.println(tableRows.get(8).findElement(By.xpath("td[3]//a")).getText()); 
		System.out.println(tableRows.get(9).findElement(By.xpath("td[3]//a")).getText()); 
	
		List <WebElement> User= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table [@class='list view table-responsive']/tbody/tr[\"+i+\"]/td[@type='relate']"))) ;
		
		System.out.println("Users column:");
		  
		System.out.println(User.get(0).findElement(By.xpath("//td[8]/a")).getText()); 
		System.out.println(User.get(1).findElement(By.xpath("//td[8]/a")).getText()); 
		System.out.println(User.get(2).findElement(By.xpath("//td[8]/a")).getText()); 
		System.out.println(User.get(3).findElement(By.xpath("//td[8]/a")).getText()); 
		System.out.println(User.get(4).findElement(By.xpath("//td[8]/a")).getText()); 
		System.out.println(User.get(5).findElement(By.xpath("//td[8]/a")).getText()); 
		System.out.println(User.get(6).findElement(By.xpath("//td[8]/a")).getText()); 
		System.out.println(User.get(7).findElement(By.xpath("//td[8]/a")).getText()); 
		System.out.println(User.get(8).findElement(By.xpath("//td[8]/a")).getText()); 
		System.out.println(User.get(9).findElement(By.xpath("//td[8]/a")).getText()); 
	    
	}

}
