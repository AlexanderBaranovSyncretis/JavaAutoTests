package uI;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import uI.pages.HomePage;
import uI.pojos.SimpleUser;

public class HomePageTest extends UITestBase {

    private static HomePage homePage;
    private static WebDriver driver;
    private static final String url = URL;
    private static final String email = MANAGER_EMAIL;
    private static final String password = MANAGER_PASSWORD;

    @BeforeEach
    public void prepareData() {
        driver = super.createDriver();
        driver.get(url);
        homePage = new HomePage(driver);

        Assertions.assertEquals(url, driver.getCurrentUrl());
        Assertions.assertEquals("Users", driver.getTitle());
    }

    @AfterEach
    public void shutDown() {
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
        SimpleUser simpleUser = UserGenerator.userGenerator();
        String emailUser = homePage
                .comeInButton()
                .logInForm(simpleUser)
                .profileButton()
                .getTextEmail();

        Assertions.assertEquals(simpleUser.getEmail(), emailUser);

        deleteUser(simpleUser.getEmail());
    }

}