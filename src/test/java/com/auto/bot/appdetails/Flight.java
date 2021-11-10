package com.auto.bot.appdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
@ConfigurationProperties("flight")
@Data
@NoArgsConstructor
@AllArgsConstructor
public
class Flight {
    private String url;
    private String heading;
    private String subHeading;
}