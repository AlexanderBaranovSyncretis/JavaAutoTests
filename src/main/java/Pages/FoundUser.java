package Pages;

import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FoundUser {

    private final By deleteButton = By.cssSelector("tr > td:nth-child(6) > a");
    private final String email = "manager@mail.ru";
    private final String password = "1";
    private final By searchForm = By.name("q");
    private final By searchButton = By.cssSelector("td > .btn");
    private final By emailColumn = By.cssSelector(".ajax_load_row td");

    public String foundUserInTable(WebDriver driver, String genEmail) {
        if (driver.findElement(searchForm).getText() != null) {
            driver.findElement(searchForm).clear();
        }
        driver.findElement(searchForm).sendKeys(genEmail);
        driver.findElement(searchButton).click();
        return driver.findElement(emailColumn).getText();
    }

    public boolean deleteUser(WebDriver driver, String genEmail) {

        HomePage homePage = new HomePage(driver)
                .logOutButton()
                .comeInButton()
                .signInForm(email, password);
        foundUserInTable(driver, genEmail);
        driver.findElement(deleteButton).click();
        return true;
    }

    public boolean deleteUserByManager(WebDriver driver, String genEmail) {
        foundUserInTable(driver, genEmail);
        driver.findElement(deleteButton).click();
        return true;
    }
}
