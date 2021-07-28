package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;
    By loginButton = By.cssSelector(".newlink:nth-child(2) span");
    By nameButton = By.className("dropdown-toggle");
    By profileButton = By.cssSelector("#fat-menu > ul > li:nth-child(1) > a");
    By exitButton = By.cssSelector("#fat-menu > ul > li:nth-child(3) > a");
    By addUserButton = By.cssSelector("p:nth-child(2) > a");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public UserLoginPage comeInButton() {
        driver.findElement(loginButton).click();

        return new UserLoginPage(driver);
    }

    public UserProfilePage profileButton() {
        driver.findElement(nameButton).click();
        driver.findElement(profileButton).click();

        return new UserProfilePage(driver);
    }

    public HomePage logOutButton() {
        driver.findElement(nameButton).click();
        driver.findElement(exitButton).click();
        return new HomePage(driver);
    }

    public UserAddPage addUserButton() {
        driver.findElement(addUserButton).click();
        return new UserAddPage(driver);
    }
}
