package pageObjects;
import java.util.List;

import org.openqa.selenium.By;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductListPage extends AbstractPage  {
	
	public ProductListPage(WebDriver driver){
		super(driver);
		
	}
	
	public ProductDescPage selectProduct(){
		
		driver.findElement(By.linkText("Professional Dishwasher Care Pack")).click();
		return new ProductDescPage(driver) ;
	}
				
	public boolean isAtPage(){
		return driver.getTitle().contains("Search");
	}
	

}
