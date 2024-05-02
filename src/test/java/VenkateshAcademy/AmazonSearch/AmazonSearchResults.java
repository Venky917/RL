package VenkateshAcademy.AmazonSearch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import VenkateshAcademy.AmazonPageobjects.SearchSuggestionsAndResults;
import VenkateshAcademy.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearchResults extends BaseTest{
	WebDriver driver;
	@Test(invocationCount = 1)
	public void amazonsearch() throws Exception {
		
		driver = initializedriver();
		SearchSuggestionsAndResults SearchResults = new SearchSuggestionsAndResults(driver);
		SearchResults.gotoAmazon();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String str = "iphone 13 pro max 128gb";
		String Expectedstr= "2018 Apple iPad Pro (12.9-inch, Wi-Fi + Cellular, 256GB) - Space Gray (Renewed)";
		str.toUpperCase();
		SearchResults.getSearchElement();
		SearchResults.enterItemtoSearch(str);
		Thread.sleep(5000);
		SearchResults.clickSearchSuggestion(str);
		Thread.sleep(5000);
		SearchResults.LoopuntilElementfoundandClick(Expectedstr);
	
	//productpage
	Boolean match  = driver.findElement(By.cssSelector("span#productTitle")).getText().equalsIgnoreCase(Expectedstr);
	Assert.assertTrue(match);
	
	}

}
