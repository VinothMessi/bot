package com.auto.bot.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.net.MalformedURLException;
import java.net.URL;

@Lazy
@Configuration
@Profile("remote")
public
class Remote {
    @Value("${hub.protocol}")
    private String protocol;

    @Value("${hub.host}")
    private String host;

    @Value("${hub.port}")
    private String port;

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public
    WebDriver remoteChrome() throws MalformedURLException {
        return new RemoteWebDriver(new URL(protocol + "://" + host + ":" + port), new ChromeOptions());
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    public
    WebDriver remoteEdge() throws MalformedURLException {
        return new RemoteWebDriver(new URL(protocol + "://" + host + ":" + port), new EdgeOptions());
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public
    WebDriver remoteFirefox() throws MalformedURLException {
        return new RemoteWebDriver(new URL(protocol + "://" + host + ":" + port), new FirefoxOptions());
    }
}