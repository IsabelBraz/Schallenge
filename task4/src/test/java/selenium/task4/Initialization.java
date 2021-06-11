package selenium.task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Initialization {
	
	public WebDriver driver;

	@BeforeClass
	public void init() {
		String rootDirectory = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",String.format("%s/drivers/%s", rootDirectory, "chromedriver.exe"));
		driver = new ChromeDriver();
		driver.get("https://link.springer.com/");
	}
	
	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
}
