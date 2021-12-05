package com.bottomline.infra.pages;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
        String propFileNamePath = PomBase.class.getClassLoader().getResource(propFileName).getPath();
        try {
            File src = new File(propFileNamePath);
            FileInputStream fileInputStream = new FileInputStream(src);
            obj.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("Can't load " + propFileName);
        }
        return obj;
    }

    public String getProperty(String prop) {
        return propFile.getProperty(prop);
    }
}
