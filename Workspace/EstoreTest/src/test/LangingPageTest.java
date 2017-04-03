package test;
//import org.junit.After;
import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.testng.annotations.AfterTest;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.BasketPage;
import pageObjects.ProductDescPage;
import pageObjects.ProductListPage;
import testdata.GetScreenshot;



public class LangingPageTest extends AbstractWebDriverTest {
	
	//WebDriver driver;
	//ExtentReports report = new ExtentReports("C:\\EstoreAutomation\\TestReports\\LatestReport.html");
	//ExtentTest logger;
	
	@BeforeTest
	public void testSetUp(){
		onLandingPage.navigateToEtore();
		
	}


	@Test
	public void testLandingPageLoaded(){
		
		logger = report.startTest("verifyLandingPageLoad");			
		logger.log(LogStatus.INFO, "Loading Landing Page");
		Assert.assertTrue("Not On Landing Page", onLandingPage.isAtPage());		
		logger.log(LogStatus.PASS, "Landing Page Loaded Correctly");	
		//report.endTest(logger);
	}
	
	@Test
	public void testSearchOnLandingPage() {
		
		
		logger = report.startTest("verifySearch");
		ProductListPage onProductListPage  = onLandingPage.searchProducts();
		logger.log(LogStatus.INFO, "Search on Landing Page Completed");
		Assert.assertTrue("Not On Product List Page", onProductListPage.isAtPage());
		logger.log(LogStatus.PASS, "Product List Page loaded correctly");		
		//report.endTest(logger);
	}
	
	@Test
	public void testProductPage() {
		
		
		logger = report.startTest("testProductPage");
		ProductListPage onProductListPage  = onLandingPage.searchProducts();
		logger.log(LogStatus.INFO, "Search on Landing Page Completed");
		Assert.assertTrue("Not On Product List Page", onProductListPage.isAtPage());
		logger.log(LogStatus.INFO, "Product List Page loaded correctly");	
		ProductDescPage onProductPage = onProductListPage.selectProduct();
		Assert.assertTrue("Not On Product Page", onProductPage.isAtPage());
		logger.log(LogStatus.INFO, "Product Page loaded correctly");	
		Assert.assertTrue("Product Name not displayed", onProductPage.isNameDisplayed());
		logger.log(LogStatus.INFO, "Product Name displayed correctly");
		Assert.assertTrue("Product Name not displayed", onProductPage.isPriceDisplayed());
		logger.log(LogStatus.INFO, "Product Price displayed correctly");
		Assert.assertTrue("AddToBasket Button not displayed", onProductPage.isAddToBasketButtonDisplayed());
		logger.log(LogStatus.INFO, "AddToBasket Button displayed correctly");
		Assert.assertTrue("Product Description not displayed", onProductPage.isProductDescDisplayed());
		logger.log(LogStatus.INFO, "Product Description displayed correctly");
		Assert.assertTrue("Product Specifications not displayed", onProductPage.isProductSpecsDisplayed());
		logger.log(LogStatus.INFO, "Product Specifications displayed correctly");
		
		logger.log(LogStatus.INFO, "Adding Product to Basket");
		onProductPage.addToBasket();
		logger.log(LogStatus.INFO, "Load Basket Page");
		BasketPage onBasketPage = onProductPage.goToBasket();
		Assert.assertTrue("Basket Page not loaded", onBasketPage.isAtPage());
		
		Assert.assertTrue("Recently Viewed Items not displayed", onProductPage.isRecentlyViewedDisplayed());
		logger.log(LogStatus.INFO, "Recently Viewed Items displayed correctly");
		
		
		//isProductDescDisplayed
	//report.endTest(logger);
	}
	
	@AfterMethod
	public void getResult(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, result.getThrowable().toString());
			String screenPath  = GetScreenshot.captureScreenshot(driver, "stepScreenshot");
			logger.log(LogStatus.FAIL, "Screenshot below  : " + logger.addScreenCapture(screenPath));
		}
	
		report.endTest(logger);
		
	}
	
	@AfterTest
	public void testCleanup(){
		
			//logger.log(LogStatus.FAIL, "Verify Product Page", "Product Page not loaded correctly");
		    
		    report.flush();
		
	}
	
	
}