package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MapPage extends BasePage {

    public MapPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchboxinput")
    public WebElement searchField;

    @FindBy(id = "searchbox-searchbutton")
    public WebElement searchButton;

    @FindBy(xpath = "//h1")
    public WebElement header;

    public void searchCity(String cityName) {
        searchField.sendKeys(cityName);
        searchButton.click();
    }

    public void isCityName(String expectedCityName) {
        String actualCityName = header.getText().trim();
        Assert.assertEquals(expectedCityName, actualCityName);
    }
}
