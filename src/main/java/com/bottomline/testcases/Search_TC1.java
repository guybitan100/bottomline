
package com.bottomline.testcases;

import com.bottomline.infra.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Search_TC1 {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https:/amazon.com");

        HomePage home = new HomePage(driver);


        home.search("Harry Potter and the Order of the Phoenix");
        System.out.println(home.getResultsNum());
        Thread.sleep(2000);
        home.setFilter("Books");
        System.out.println(home.getResultsNum());
        Thread.sleep(7000);
        driver.quit();
    }

}
