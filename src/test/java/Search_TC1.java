import com.bottomline.infra.drivers.ChromeWebDriver;
import com.bottomline.infra.pages.HomePage;
import org.openqa.selenium.WebDriver;


public class Search_TC1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeWebDriver().get();
        HomePage home = new HomePage(driver);
        home.search("Harry Potter and the Order of the Phoenix");
        System.out.println(home.getResultsNum());
        Thread.sleep(100);
        home.setFilter("Books");
        System.out.println(home.getResultsNum());
        System.out.println(home.getMaxName());
        Thread.sleep(100);
        driver.quit();
    }

}
