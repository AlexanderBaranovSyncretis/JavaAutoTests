package uI;

import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

import static rest.RestTestBase.deleteUserByAPI;
import static rest.utils.PropHelper.properties;
import static rest.utils.UserType.MANAGER;

public class UITestBase extends DriverFactory {
    public static final String URL = "http://users.bugred.ru/";
    public static final String MANAGER_EMAIL = properties.get(MANAGER + ".name").toString();
    public static final String MANAGER_PASSWORD = properties.get(MANAGER + ".password").toString();

    public static void deleteUser(String email) {
        deleteUserByAPI(email);
    }
}
