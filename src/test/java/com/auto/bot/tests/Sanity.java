package com.auto.bot.tests;

import com.auto.bot.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public
class Sanity extends BaseTests {
    @Test
    public
    void sanity() {
        System.out.println("Sanity Test Case");

        browser.manage().window().maximize();
        browser.navigate().to("https://vins-udemy.s3.amazonaws.com/sb/visa/udemy-visa.html");

        WebElement header = browser.findElement(By.id("header_1"));
        WebElement subHeader = browser.findElement(By.id("subHeader_1"));

        assertThat(header.isDisplayed() && header.isEnabled()).isTrue();
        assertThat(subHeader.isDisplayed() && subHeader.isEnabled()).isTrue();

        browser.quit();
    }
}