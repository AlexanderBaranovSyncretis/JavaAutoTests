package com;

import Pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class OneTest extends DriverFactory {

    Person person;
    WebDriver driver;
    String url;
    String email = "manager@mail.ru";
    String password = "1";
    boolean isFlag = false;
    String genEmail;

    @Before
    public void setUp() {
        driver = super.createDriver();
        url = "http://users.bugred.ru/";
        driver.get(url);
        assertEquals(url, driver.getCurrentUrl());
        assertEquals("Users", driver.getTitle());
    }

    @After
    public void shutDown() {
        if (isFlag) {
            FoundUser delUser = new FoundUser();
            if (delUser.deleteUser(driver, person.getEmail())) {
                isFlag = false;
            }
        }
        driver.close();
    }

    @Test
    public void logIn() {
        HomePage homePage = new HomePage(driver);
        String emailUser = homePage
                .comeInButton()
                .signInForm(email, password)
                .profileButton()
                .getTextEmail();
        assertEquals(email, emailUser);
    }

    @Test
    public void registration() {
        UserGenerator userGen = new UserGenerator();
        person = userGen.userGenerator();
        isFlag = true;
        HomePage homePage = new HomePage(driver);
        String emailUser = homePage
                .comeInButton()
                .logInForm(person)
                .profileButton()
                .getTextEmail();
        assertEquals(person.getEmail(), emailUser);
    }

}