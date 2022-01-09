package Tests;

import Pages.MapPage;
import Pages.Menu;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MapSearchTest extends BaseTest {
    String city = "Boise";

    MapPage mapPage;
    Menu menu;

    private BaseTest base;

    public MapSearchTest(BaseTest base) {
        this.base = base;
    }

    @Given("the user navigates to maps successfully")
    public void the_user_navigates_to_maps_successfully() {
        menu = new Menu(base.driver);
        mapPage = menu.get(Menu.Item.MAPS);
        mapPage.isPageTitle("Google Maps");
    }

    @When("the user searches a city name")
    public void the_user_searches_a_city_name() {
        mapPage.searchCity(city);
    }

    @Then("the city search results appear successfully")
    public void the_city_search_results_appear_successfully() {
        mapPage.isCityName(city);
    }
}
