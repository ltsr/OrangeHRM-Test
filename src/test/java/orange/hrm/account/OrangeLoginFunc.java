package orange.hrm.account;

import orange.hrm.pom.PageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeLoginFunc {
    public static void loginAccount(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjectModel.loginButton));

        driver.findElement(PageObjectModel.usernameField).sendKeys(PageObjectModel.username);
        driver.findElement(PageObjectModel.passwordField).sendKeys(PageObjectModel.password);

        Thread.sleep(2000);

        driver.findElement(PageObjectModel.loginButton).click();
    }
}
