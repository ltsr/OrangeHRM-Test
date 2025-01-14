package orange.hrm.util;

import orange.hrm.pom.PageObjectModel;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeUtils {
    public static void searchPim(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        driver.findElement(PageObjectModel.pimLink).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjectModel.pimSearchButton));

        driver.findElement(PageObjectModel.pimEmployeeNameField).sendKeys(PageObjectModel.pimEmployeeName);
        driver.findElement(PageObjectModel.pimEmployeeIdField).sendKeys(PageObjectModel.pimEmployeeId);
        driver.findElement(PageObjectModel.pimEmploymentStatusDropdownMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjectModel.getPimEmploymentStatusOption));
        driver.findElement(PageObjectModel.getPimEmploymentStatusOption).click();

        //driver.findElement(PageObjectModel.pimIncludeDropdownMenu).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjectModel.pimIncludeDropdownMenu));

        driver.findElement(PageObjectModel.pimSupervisorNameField).sendKeys(PageObjectModel.pimSupervisorName);

        // The site has to load the results so we wait for the element's result to change from "Searching..." to an actual search result
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(driver.findElement(PageObjectModel.pimSuperVisorOption), "Searching...")));

        driver.findElement(PageObjectModel.pimSuperVisorOption).click();
        driver.findElement(PageObjectModel.pimJobTitleDropdownMenu).click();
        driver.findElement(PageObjectModel.pimJobTitleOption).click();
        driver.findElement(PageObjectModel.pimSubUnitDropdownMenu).click();
        driver.findElement(PageObjectModel.pimSubUnitOption).click();

        driver.findElement(PageObjectModel.pimSearchButton).click();

        String searchResult = "";

        try {
            searchResult = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]")).getText();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(3000);

        Assert.assertEquals("0103", searchResult);


    }
}
