package com.auto.bot;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@SpringBootTest
public
abstract
class BaseTest extends AbstractTestNGSpringContextTests {
    @Autowired
    protected
    WebDriver browser;

    @BeforeClass
    public
    void setUp() {
        browser.manage().window().maximize();
    }

    @AfterClass
    public
    void shutDown() {
        browser.quit();
    }
}