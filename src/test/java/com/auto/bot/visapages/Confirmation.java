package com.auto.bot.visapages;

import com.auto.bot.BasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@Lazy
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public
class Confirmation extends BasePage {
    By panel = By.id("panel");
    By requestnumber = By.id("requestnumber");

    @Override
    protected
    boolean hasLoaded() {
        await().pollInterval(3, TimeUnit.SECONDS)
                .until(() -> canWeClickOn(requestnumber));
        return canWeClickOn(panel);
    }

    public
    String message() {
        return getTextFrom(panel);
    }
}