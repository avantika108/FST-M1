import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();

		driver.get("http://alchemy.hguy.co/crm");
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//*[@id=\'bigbutton\']")).click();
		
		WebElement Sales = driver.findElement(By.id("grouptab_0"));
		Sales.click();
	 
		WebElement Accounts=driver.findElement(By.id("moduleTab_9_Accounts"));
		Accounts.click();
	 
		WebDriverWait wait = new WebDriverWait(driver,30);
		List <WebElement> tableRows =  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='list-view-rounded-corners']/table/tbody/tr")));
	 
	  
		System.out.println("Number of rows are: " + tableRows.size());
	  
		System.out.println("Names are:");
//	  @SuppressWarnings("unused")
//	WebElement name 	=  tableRows.get(0).findElement(By.xpath("td[3]//a"));
	  
	  
	System.out.println(tableRows.get(0).findElement(By.xpath("td[3]//a")).getText()); 
	System.out.println(tableRows.get(2).findElement(By.xpath("td[3]//a")).getText()); 
	System.out.println(tableRows.get(4).findElement(By.xpath("td[3]//a")).getText()); 
	System.out.println(tableRows.get(6).findElement(By.xpath("td[3]//a")).getText()); 
	System.out.println(tableRows.get(8).findElement(By.xpath("td[3]//a")).getText()); 
	  
	
	  
	  
	  

//	  //Get columns
//     List<WebElement> cols = driver.findElements(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/thead/tr[1]/th[1]/td"));
//     //Get rows
//     List<WebElement> rows = driver.findElements(By.xpath(" /html/body/div[4]/div/div[3]/form[2]/div[3]/table/thead/tr[2]/td"));

//     //Number of columns
//     System.out.println("Number of columns are: " + cols.size());
//     //Number of rows
//     System.out.println("Number of rows are: " + rows.size());


	}

}
