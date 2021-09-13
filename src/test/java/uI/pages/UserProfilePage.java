package uI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserProfilePage {

    WebDriver driver;
    By emailUser = By.cssSelector("p > .btn");
    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextEmail() {
        return driver.findElement(emailUser).getText();
    }


}
