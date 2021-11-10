package com.auto.bot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public
abstract
class BasePage {
    @Autowired
    protected
    WebDriver browser;

    protected abstract
    boolean hasLoaded();

    protected
    WebElement find(By locator) {
        return browser.findElement(locator);
    }

    protected
    List<WebElement> findAll(By locator) {
        return browser.findElements(locator);
    }

    protected
    boolean isPresent(By locator) {
        List<WebElement> elements = findAll(locator);
        if (elements.size() < 0) {
            return false;
        }
        return true;
    }

    protected
    boolean canWeSee(By locator) {
        return find(locator).isDisplayed();
    }

    protected
    boolean canWeClickOn(By locator) {
        return find(locator).isEnabled();
    }

    protected
    void clickOn(By locator) {
        find(locator).click();
    }

    protected
    void clearOut(By locator) {
        find(locator).clear();
    }

    protected
    void type(String text, By locator) {
        find(locator).sendKeys(text);
    }

    protected
    String getTextFrom(By locator) {
        return find(locator).getText().trim().toString();
    }

    protected
    void select(String condition, String option, By locator) {
        Select dropDown = new Select(find(locator));
        switch (condition) {
            case "text":
                dropDown.selectByVisibleText(option);
                break;
            case "value":
                dropDown.selectByValue(option);
                break;
            case "index":
                dropDown.selectByIndex(Integer.parseInt(option));
                break;
        }
    }
}