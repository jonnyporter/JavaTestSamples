package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MapPage {
    WebDriver driver;

    @FindBy(id = "searchboxinput")
    WebElement searchField;

    @FindBy(id = "searchbox-searchbutton")
    WebElement searchButton;

    @FindBy(xpath = "//h1")
    WebElement header;

    public void checkTitle() {
        String actualTitle = driver.getTitle().trim();
        Assert.assertEquals(actualTitle, "Google Maps");
    }

    public void searchCity(String cityName) {
        searchField.sendKeys(cityName);
        searchButton.click();
    }

    public void confirmCity(String expectedCityName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(header));
        String actualCityName = header.getText().trim();
        Assert.assertEquals(expectedCityName, actualCityName);
    }

    public MapPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
