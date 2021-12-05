package com.bottomline.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*

 */

public class HomePage extends PomBase {

    public HomePage(WebDriver driver) {
        super(driver, "HomePage.properties");
    }

    public void search(String keys) {
        driver.findElement(By.id(getProperty("search.id"))).sendKeys(keys);
        driver.findElement(By.id(getProperty("search.submit.id"))).click();
    }

    public void setFilter(String filter){
        new Select(driver.findElement(By.id(getProperty("search.filter.id")))).selectByVisibleText(filter);
        driver.findElement(By.id(getProperty("search.submit.id"))).click();
        driver.findElement(By.xpath(getProperty("search.filter.english.xpath"))).click();
    }

    public int getResultsNum() {
        String pattern = "^\\d-\\d+\\s+of\\s+(\\d+)\\s+results";
        String results = driver.findElement(By.xpath(getProperty("search.results.xpath"))).getText();
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(results);
        if (m.find()) {
            return Integer.parseInt(m.group(1));
        }
        return 0;
    }
}