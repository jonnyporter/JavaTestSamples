package Tests;

import Pages.HomePage;
import Pages.MapPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MapSearchTest {
    String driverPath = "/Users/jonathanporter/Developer/testFiles/chromedriver";
    String city = "Boise";
    WebDriver driver;
    Pages.HomePage homePage;
    Pages.MapPage mapPage;

    @Before
    public void setup() {
        // Setting driver location
        System.setProperty("webdriver.chrome.driver", driverPath);
        // ChromeDriver setup
        driver = new ChromeDriver();
        // Getting URL
        driver.get("https://www.google.com/");
    }

    @Given("the user goes to home page")
    public void the_user_goes_to_home_page() {
        // Initializing Home Page
        homePage = new HomePage(driver);
        // Check that page is Home Page
        homePage.checkTitle();
    }

    @And("the user navigates to maps successfully")
    public void the_user_navigates_to_maps_successfully() {
        // Navigating to Maps button
        homePage.goToMaps();
        // Initializing Map Page
        mapPage = new MapPage(driver);
        // Check that page is Map Page
        mapPage.checkTitle();
    }

    @When("the user searches a city name")
    public void the_user_searches_a_city_name() {
        // Searching city in search field
        mapPage.searchCity(city);
    }

    @Then("the city search results appear successfully")
    public void the_city_search_results_appear_successfully() {
        // Asserting city searched matches city results
        mapPage.confirmCity(city);
    }

    @After
    public void tearDown() {
        // Close driver
        driver.close();
    }
}
