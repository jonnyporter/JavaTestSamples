package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Menu extends BasePage {

    public enum Item {
        MAPS("Maps"),
        YOUTUBE("YouTube");

        private final String name;

        Item(String name) {
            this.name = name;
        }

        public BasePage getPage(WebDriver driver) {
            switch (name) {
                case "Maps":
                    return new MapPage(driver);
                case "YouTube":
                    return new YouTubePage(driver);
                default:
                    throw new RuntimeException("Page " + name + " does not exist.");
            }
        }
    }

    public Menu(WebDriver driver) {
        super(driver);
    }


    // TODO: Implement initialization of generic page object
    public <T extends BasePage> T get(Item item) {
        menuButton.click();
        driver.switchTo().frame(menuFrame);
        driver.findElement(By.linkText(item.name)).click();
        return (T) item.getPage(driver);
    }
}
