package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    @FindBy(css = "a[aria-label=\"Google apps\"]")
    public WebElement menuButton;

    @FindBy(tagName = "iframe")
    public WebElement menuFrame;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void isPageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle().trim();
        Assert.assertEquals(expectedTitle, actualTitle);
    }


}
