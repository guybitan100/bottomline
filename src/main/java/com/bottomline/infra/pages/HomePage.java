package com.bottomline.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HomePage extends PomBase {


    public HomePage(WebDriver driver) {
        super(driver, "HomePage.properties");
    }

    public void search(String keys) {
        driver.findElement(By.id(getProperty("search.id"))).sendKeys(keys);
        driver.findElement(By.id(getProperty("search.submit.id"))).click();
    }

    public void setFilter(String filter) {
        new Select(driver.findElement(By.id(getProperty("search.filter.id")))).selectByVisibleText(filter);
        driver.findElement(By.id(getProperty("search.submit.id"))).click();
        driver.findElement(By.xpath(getProperty("search.filter.english.xpath"))).click();
    }

    public int getResultsNum() {
        String pattern = "^\\d-\\d+\\s+of\\s+(\\d+)\\s+results";
        String results = driver.findElement(By.xpath(getProperty("search.results.xpath"))).getText();
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(results);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }

    public String getMaxName() {
        String pattern = "^(HARRY POTTER.*)[,|:|-]";
        String results = (driver.findElement(By.xpath(getProperty("search.results.all.xpath"))).getText());
        Pattern r = Pattern.compile(pattern, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        Matcher matcher = r.matcher(results);
        String maxName = "";
        while (matcher.find()) {
            if (matcher.group(1).length() > maxName.length()) {
                maxName = matcher.group(1);
            }
        }
        return maxName;
    }
}
