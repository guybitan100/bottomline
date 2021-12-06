package com.bottomline.infra.pages;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.Properties;

public abstract class PomBase {

    protected WebDriver driver;
    protected Properties propFile;
    protected String propFileName;

    public PomBase(WebDriver driver, String propertiesFile) {
        this.driver = driver;
        this.propFileName = propertiesFile;
        this.propFile = loadProperties();
    }


    public Properties loadProperties() {
        Properties obj = new Properties();
        InputStream in = PomBase.class.getClassLoader().getResourceAsStream(propFileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            obj.load(reader);
        } catch (IOException e) {
            System.out.println("Can't load " + propFileName);
        }
        return obj;
    }

    public String getProperty(String prop) {
        return propFile.getProperty(prop);
    }
}
