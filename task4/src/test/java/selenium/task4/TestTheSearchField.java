package selenium.task4;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTheSearchField extends Initialization{
	
	PageClass pc; 
	
	

	@Test
	public void enterKeywordsThatReturnsResults() {
		pc = new PageClass(driver);
		pc.clearSearch();
		pc.enterSearchKeywordsAndClick("organic memories");
		List<String> resultsTitles = pc.getResultsTitles();
		//This assertion fails because it was made to check only the titles, the search is not taking
		//into account only the titles that is why it will fail
		Assert.assertTrue(Utils.doAllTitlesContainTheKeywords(resultsTitles, "organic","memories"));
	}
	
	@Test
	public void enterKeywordsThatDoNotReturnResults() {
		pc = new PageClass(driver);
		pc.clearSearch();
		pc.enterSearchKeywordsAndClick("xdlllutf");
		String t = pc.getResultsText();
		Assert.assertTrue(t.contains("0 Result(s) for 'xdlllutf'"));
		Assert.assertTrue(pc.isNoResultsMessagePresent());
	}
	
}
