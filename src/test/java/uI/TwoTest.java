package uI;

import pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TwoTest extends DriverFactory {

    WebDriver driver;
    Person person;
    FoundUser foundUser;
    String url;
    String email = "manager@mail.ru";
    String password = "1";
    boolean isFlag = false;
    String genEmail;
    private HomePage homePage;

    @Before
    public void setUp() {
        driver = super.createDriver();
        url = "http://users.bugred.ru/";
        driver.get(url);
        assertEquals(url, driver.getCurrentUrl());
        assertEquals("Users", driver.getTitle());
        homePage = new HomePage(driver)
                .comeInButton()
                .signInForm(email, password);
    }

    @After
    public void shutDown() {
        if (isFlag) {
            FoundUser delUser = new FoundUser();
            if (delUser.deleteUserByManager(driver, person.getEmail())) {
                isFlag = false;
            }
        }
        driver.close();
    }

    @Test
    public void createUser() {
        UserGenerator userGen = new UserGenerator();
        person = userGen.userGenerator();
        homePage.addUserButton().getTable(person);
        foundUser = new FoundUser();
        isFlag = true;
        assertEquals(person.getEmail(), foundUser.foundUserInTable(driver, person.getEmail()));
    }
}
