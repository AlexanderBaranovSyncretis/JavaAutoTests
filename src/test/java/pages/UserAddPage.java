package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserAddPage {

    WebDriver driver;
    UserGenerator userGen;
    By tableOfFields = By.cssSelector(".table input");

    public UserAddPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getTable(Person person) {
        List<WebElement> inputFields = driver.findElements(tableOfFields);
        for (int count = 0; count < 3; count++) {
            if (count == 1) {
                inputFields.get(count).sendKeys(person.getEmail());
                continue;
            }
            inputFields.get(count).sendKeys(person.getName());
        }

        inputFields.get(inputFields.size() - 1).click();
        return new HomePage(driver);
    }


}
