package VenkateshAcademy.AmazonPageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.UsableComponents;

public class SearchSuggestionsAndResults extends UsableComponents{
	
	WebDriver driver;
	
	public SearchSuggestionsAndResults(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	By searchbox = By.cssSelector("input#twotabsearchtextbox");
	
	By searchproductsby = By.cssSelector(".s-suggestion");
	
	@FindBy(css=".s-suggestion")
	List<WebElement> products;
	

	@FindBy(css=".a-size-mini")
	List<WebElement> Results;
	

	@FindBy(css=".s-pagination-item:last-child")
	WebElement nextpagebtn;
	
	
	public void gotoAmazon() {
		driver.get("https://www.amazon.com/");
		
	}
	public WebElement getSearchElement() {
	WebElement ele = waitforElementToAppearandReturn(searchbox);
	return ele;
	
	}
	
	public void enterItemtoSearch(String str) {
		getSearchElement().sendKeys(str);
	}
	

public void clickSearchSuggestion(String str) {


	List<WebElement> SearchSuggestions = driver.findElements(By.cssSelector(".s-suggestion"));
	 WebElement ele1 = SearchSuggestions.stream().filter(s->s.getText().equalsIgnoreCase(str)).findFirst().orElse(null);
	ele1.click();

	}
public void LoopuntilElementfoundandClick(String expectedstr) throws InterruptedException {
	
	Boolean flag=false;
	while(!flag) {
		//List<WebElement> ResultSearch = driver.findElements(By.cssSelector(".a-size-mini"));
		WebElement ele2 = Results.stream().filter(p->p.findElement(By.cssSelector("span")).getText().equalsIgnoreCase(expectedstr)).findFirst().orElse(null);
	    if(ele2!=null) {
		ele2.click();
	
		flag=true;
        break;
		}
	
	////h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']
	
	
	if(!flag) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",nextpagebtn);
		nextpagebtn.click();
		Thread.sleep(10000);
		Results.clear();
	}
	}
	
}

}
