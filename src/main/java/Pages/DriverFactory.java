package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public abstract class DriverFactory {

    public WebDriver createDriver() {
        WebDriver driver;
        String browser = System.getProperty("browser");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
//        switch (browser) {
//            case "edge":
//                WebDriverManager.edgedriver().setup();
//                driver = new EdgeDriver();
//                break;
//            case "opera":
//                WebDriverManager.operadriver().setup();
//                driver = new OperaDriver();
//                break;
//            case "firefox":
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                break;
//            case "chrome":
//            default:
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//        }
        driver.manage().window().maximize();
        return driver;
    }
}
