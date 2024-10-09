import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @Test
    public void testGoogleSearch() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.search("automated testing");
        GoogleResultsPage resultsPage = new GoogleResultsPage(driver);
        Assert.assertTrue(resultsPage.isResultsFound(), "Search results not found");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
