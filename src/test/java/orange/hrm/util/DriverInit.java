package orange.hrm.util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DriverInit {
    public ChromeDriver driver;
    public WebDriverWait wait;
    public String baseURL = "https://opensource-demo.orangehrmlive.com/";

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(baseURL);
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
