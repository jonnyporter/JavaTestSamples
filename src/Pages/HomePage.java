package Pages;

import io.cucumber.java.da.Men;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    @FindBy(className = "gb_C")
    WebElement MenuButton;

    @FindBy(tagName = "iframe")
    WebElement MenuFrame;

    @FindBy(css = "a[href='https://maps.google.com/maps?hl=en']")
    WebElement MapsButton;

    public void goToMaps() {
        MenuButton.click();
        driver.switchTo().frame(MenuFrame);
        MapsButton.click();
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;

        // This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
}
