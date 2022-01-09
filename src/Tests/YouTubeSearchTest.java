package Tests;

import Pages.Menu;
import Pages.YouTubePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class YouTubeSearchTest extends BaseTest {
    String video = "Boise";

    YouTubePage youTubePage;
    Menu menu;

    private BaseTest base;

    public YouTubeSearchTest(BaseTest base) {
        this.base = base;
    }

    @Given("the user navigates to youtube successfully")
    public void the_user_navigates_to_youtube_successfully() {
        menu = new Menu(base.driver);
        youTubePage = menu.get(Menu.Item.YOUTUBE);
        youTubePage.isPageTitle("YouTube");
    }

    @When("the user searches a video")
    public void the_user_searches_a_video() {
        youTubePage.searchVideo(video);
    }

    @Then("the video search results appear successfully")
    public void the_video_search_results_appear_successfully() {
        youTubePage.isVideoName(video);
    }

}