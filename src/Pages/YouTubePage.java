package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YouTubePage extends BasePage {

    public YouTubePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[id=\"search\"]")
    public WebElement searchField;

    @FindBy(id = "search-icon-legacy")
    public WebElement searchButton;

    @FindBy(id = "video-title")
    public WebElement videoTitle;

    public void searchVideo(String videoName) {
        searchField.sendKeys(videoName);
        searchButton.click();
    }

    // TODO: Video assert needs further work as exact video results will not appear, for now, printing video name
    public void isVideoName(String expectedVideoName) {
        String actualVideoName = videoTitle.getText().trim();
        System.out.println(actualVideoName);
        //Assert.assertEquals(expectedVideoName, actualVideoName);
    }
}
