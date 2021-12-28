package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MapPage {
    WebDriver driver;

    @FindBy(id = "searchboxinput")
    WebElement SearchField;

    @FindBy(id = "searchbox-searchbutton")
    WebElement SearchButton;

    @FindBy(xpath = "//span[text()='Boise']")
    WebElement CityLabel;

    public void searchCity(String cityName) {
        SearchField.sendKeys(cityName);
        SearchButton.click();
    }

    public void confirmCity(String cityName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + cityName + "']")));
        WebElement e = driver.findElement(By.xpath("//span[text()='" + cityName + "']"));
        Assert.assertEquals(cityName, e.getText());
    }

    public MapPage(WebDriver driver) {
        this.driver = driver;

        // This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
}
