package selenium.task4;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageClass 
{
	private WebDriver driver;
	private WebDriverWait wait;
   
	private By searchField = By.id("query");
	private By searchSubmit = By.id("search");
	private By results = By.id("results-list");
	private By nOfResultsText = By.id("number-of-search-results-and-search-terms");
	private By noResultsMessage = By.id("no-results-message");
		
	
	public PageClass (WebDriver driver) {
	   this.driver = driver;
	   wait = new WebDriverWait(driver, 10000);
   }
	
	public void clearSearch () {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchField))).clear();
	}
	
	public String getResultsText () {
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(nOfResultsText))).getText();
	}
	
	public boolean isNoResultsMessagePresent () {
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(noResultsMessage)));
			return true;
		} catch (NoSuchElementException nsee) {
			return false;
		} catch (TimeoutException  toe) {
			return false;
		}
	}
	public void enterSearchKeywordsAndClick (String keywords) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchField))).sendKeys(keywords);
		driver.findElement(searchSubmit).click();
	}
	
	private List<WebElement> getTableResults () {
		return wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(results).findElements(By.tagName("li"))));
	}
	
	public List<String> getResultsTitles () {
		List<String> titlesList = new ArrayList<String>();
		for (WebElement e : getTableResults()) {
			titlesList.add(e.getText());
		}
		return titlesList;
	}
}
