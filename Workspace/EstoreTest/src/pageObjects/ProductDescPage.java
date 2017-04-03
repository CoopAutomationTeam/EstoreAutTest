package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDescPage extends AbstractPage {
	
	public ProductDescPage(WebDriver driver){
		super(driver);
	}
	
	public boolean isAtPage(){
		return driver.getTitle().contains("Buy ");
	}
	
	public boolean isNameDisplayed(){
		
		return driver.findElement(By.cssSelector("h1[itemprop='name']")).isDisplayed();
		 
	}
	
	
	public boolean isPriceDisplayed(){
		
		return driver.findElement(By.cssSelector("div[class='col-xs-5 col-sm-12 h1 no-margins-v strong text-accessible']")).isDisplayed();
		 
	}
	
		
	public boolean isProductDescDisplayed(){
		
		return driver.findElement(By.cssSelector("a[title='Product Description']")).isDisplayed();
		 
	}
	
	public boolean isAddToBasketButtonDisplayed(){
		
		return driver.findElement(By.xpath(".//*[@id='addToBasketArea']/div[1]/a")).isDisplayed();
		 
	}

	
	public boolean isProductSpecsDisplayed(){
		
		return driver.findElement(By.cssSelector("a[title='Specification']")).isDisplayed();
		
	}

	
	public boolean isRecentlyViewedDisplayed(){
		
		return driver.findElement(By.xpath(".//*[@id='content']/section/div[1]/h3")).isDisplayed();		
	}
	
	public void addToBasket(){
		
		driver.findElement(By.cssSelector("a[title='Checkout Now'][class='btn btn-success btn-sm btn-block']")).click();
		
	}
	
	public BasketPage goToBasket(){
		
		driver.findElement(By.cssSelector("span[class='visible-md visible-lg']"));
		return new BasketPage(driver);
	}
}