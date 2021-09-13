package uI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uI.pojos.SimpleUser;

public class UserLoginPage {

    WebDriver driver;
    public UserLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage signInForm(String email, String password) {
        driver.findElement(By.name("login")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("tr:nth-child(3) .btn")).click();

        return new HomePage(driver);
    }

    public HomePage logInForm(SimpleUser simpleUser) {
        driver.findElement(By.name("name")).sendKeys(simpleUser.getName());
        driver.findElement(By.name("email")).sendKeys(simpleUser.getEmail());
        driver.findElement(By.cssSelector("form:nth-child(4) tr:nth-child(3) input")).sendKeys(simpleUser.getPassword());
        driver.findElement(By.name("act_register_now")).click();

        return new HomePage(driver);
    }
}
