package com.auto.bot.tests;

import com.auto.bot.BotTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public
class GoogleTest extends BotTests {
    @Test
    public
    void google() {
        System.out.println("Google Test");

        browser.manage().window().maximize();
        browser.navigate().to("https://www.google.com/");

        WebElement search = browser.findElement(By.xpath("(//input[@name='btnK'])[2]"));
        WebElement lucky = browser.findElement(By.xpath("(//input[@name='btnI'])[2]"));

        assertThat(search.isDisplayed() && search.isEnabled()).isTrue();
        assertThat(lucky.isDisplayed() && lucky.isEnabled()).isTrue();

        browser.quit();
    }
}