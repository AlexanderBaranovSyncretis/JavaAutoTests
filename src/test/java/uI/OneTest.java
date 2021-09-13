package uI;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.DriverFactory;

public class OneTest extends DriverFactory {

    private static HomePage homePage;
    private static WebDriver driver;
    private static final String url = "http://users.bugred.ru/";
    private static final String email = "manager@mail.ru";
    private static final String password = "1";

    @BeforeEach
    public void prepareData() {
        driver = super.createDriver();
        driver.get(url);
        homePage = new HomePage(driver);

        Assertions.assertEquals(url, driver.getCurrentUrl());
        Assertions.assertEquals("Users", driver.getTitle());
    }

    @AfterAll
    static void shutDown() {
        driver.close();
    }

    @Test
    @DisplayName("login test")
    public void logIn() {
        String emailUser = homePage
                .comeInButton()
                .signInForm(email, password)
                .profileButton()
                .getTextEmail();

        Assertions.assertEquals(email, emailUser);
    }

    @Test
    @DisplayName("registration test")
    public void registration() {
        Person person = UserGenerator.userGenerator();
        String emailUser = homePage
                .comeInButton()
                .logInForm(person)
                .profileButton()
                .getTextEmail();

        Assertions.assertEquals(person.getEmail(), emailUser);

        new FoundUser().deleteUser(driver, person.getEmail());
    }

}