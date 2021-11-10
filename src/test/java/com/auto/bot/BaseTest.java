package com.auto.bot;

import com.auto.bot.visapages.VisaForm;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@SpringBootTest
public
abstract
class BaseTest extends AbstractTestNGSpringContextTests {
    @Autowired
    protected
    WebDriver browser;

    @Autowired
    protected
    VisaForm visaForm;

    @BeforeTest
    public
    void setUp() {
        browser.manage().window().maximize();
    }

    @AfterTest
    public
    void shutDown() {
        browser.quit();
    }

    @BeforeClass(alwaysRun = true)
    @BeforeSuite(alwaysRun = true)
    @Override
    public
    void springTestContextPrepareTestInstance() throws Exception {
        super.springTestContextPrepareTestInstance();
    }
}