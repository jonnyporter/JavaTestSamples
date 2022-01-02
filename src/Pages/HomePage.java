package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "gb_C")
    WebElement menuButton;

    @FindBy(tagName = "iframe")
    WebElement menuFrame;

    @FindBy(css = "a[href='https://maps.google.com/maps?hl=en']")
    WebElement mapsButton;

    public void checkTitle() {
        String actualTitle = driver.getTitle().trim();
        Assert.assertEquals(actualTitle, "Google");
    }

    public void goToMaps() {
        menuButton.click();
        driver.switchTo().frame(menuFrame);
        mapsButton.click();
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
