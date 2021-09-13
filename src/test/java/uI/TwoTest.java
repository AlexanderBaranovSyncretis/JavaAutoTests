package uI;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import uI.pages.FoundUser;
import uI.pages.HomePage;
import uI.pojos.SimpleUser;

public class TwoTest extends UITestBase {

    private static WebDriver driver;
    private static final String url = URL;
    private static final String email = MANAGER_EMAIL;
    private static final String password = MANAGER_PASSWORD;
    private static HomePage homePage;

    @BeforeEach
    public void setUp() {
        driver = super.createDriver();
        driver.get(url);

        Assertions.assertEquals(url, driver.getCurrentUrl());
        Assertions.assertEquals("Users", driver.getTitle());
        homePage = new HomePage(driver)
                .comeInButton()
                .signInForm(email, password);
    }

    @AfterEach
    public void shutDown() {
        driver.close();
    }

    @Test
    @DisplayName("create user by manager test")
    public void createUser() {
        SimpleUser simpleUser = UserGenerator.userGenerator();
        homePage.addUserButton().getTable(simpleUser);

        Assertions.assertEquals(simpleUser.getEmail(),
                new FoundUser().foundUserInTable(driver, simpleUser.getEmail()));

        deleteUser(simpleUser.getEmail());
    }
}
