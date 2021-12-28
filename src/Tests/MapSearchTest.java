package Tests;

import Pages.HomePage;
import Pages.MapPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.scene.control.MenuButton;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MapSearchTest {
    String driverPath = "/Users/jonathanporter/Developer/testFiles/chromedriver";
    WebDriver driver;
    Pages.HomePage homePage;
    Pages.MapPage mapPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");

    }

    @Given("user goes to home page")
    public void user_goes_to_home_page() {
        homePage = new HomePage(driver);
    }

    @And("user navigates to maps successfully")
    public void user_navigates_to_maps_successfully() {
        homePage.goToMaps();
    }

    @When("user searches a city name")
    public void user_searches_a_city_name() {
        mapPage = new MapPage(driver);
        mapPage.searchCity("Boise");
    }

    @Then("city search results appear successfully")
    public void city_search_results_appear_successfully() {
        mapPage.confirmCity("Boise");
    }

    @After
    public void close() {
        driver.close();
    }
}
