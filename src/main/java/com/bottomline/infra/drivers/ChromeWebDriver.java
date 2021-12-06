package com.bottomline.infra.drivers;

import com.bottomline.infra.pages.PomBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ChromeWebDriver {
    WebDriver driver;
    Properties prop;

    public ChromeWebDriver() {
        loadProperties();
        WebDriverManager.chromedriver().browserVersion(prop.getProperty("browserVersion")).setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        this.driver = new ChromeDriver(options);
    }

    public void loadProperties() {
        this.prop = new Properties();
        InputStream in = PomBase.class.getClassLoader().getResourceAsStream("project.properties");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            prop.load(reader);
        } catch (IOException e) {
            System.out.println("Can't load project.properties");
        }
    }

    public WebDriver get() {
        driver.get(prop.getProperty("baseUrl"));
        return driver;
    }
}
