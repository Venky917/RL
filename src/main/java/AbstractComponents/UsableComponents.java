package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsableComponents {
	
	WebDriver driver;
	
	public UsableComponents(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	
public WebElement waitforElementToAppearandReturn(By findby) {
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	return ele;
	
}

public void waitforElementtoAppear(By findby) {
	
	WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(20));
	wait4.until(ExpectedConditions.visibilityOfElementLocated(findby));

}
}
