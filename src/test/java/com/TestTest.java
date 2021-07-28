package com;

import Pages.DriverFactory;
import Pages.FoundUser;
import Pages.HomePage;
import Pages.UserGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class TestTest extends DriverFactory {

    WebDriver driver;
    String url;

    @Before
    public void setUp() {
        driver = super.createDriver();
        url = "https://litecart.stqa.ru/en/acme-corp-m-1/";
        driver.get(url);
    }

    @After
    public void shutDown() {
        driver.close();
    }

    @Test
    public void findElementt() {
        By product = By.cssSelector(".product");
        By stickerSale = By.cssSelector(".sticker.sale");
        By zoom = By.cssSelector(".zoomable");
        WebElement zoomable = driver
                .findElements(product)
                .stream()
                .filter(el -> el.findElements(stickerSale).size() > 0)
                .findFirst()
                .orElseThrow(() -> new Error("No products to sale"))
                .findElement(zoom);
        System.out.println(zoomable);

    }
}
