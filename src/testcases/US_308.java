package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

public class US_308 extends BaseDriver {

    @Test
    public void test8() throws AWTException {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement eCommerceBtn = driver.findElement(By.cssSelector("a[class=\"EJ-ShopLink\"]"));
        eCommerceBtn.click();

        WebElement logo= driver.findElement(By.cssSelector("a[href='/']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/']")));
        logo.click();

        WebElement seeHowItWorksBtn = driver.findElement(By.cssSelector("div[class=\"banner_btn\"] a"));
        seeHowItWorksBtn.click();

        Robot robot = new Robot();
        //TODO for Mac
        //************************//
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            }
        //************************//
        for (int i = 0; i < 15; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.delay(10000);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);

        WebElement youtubeClose = driver.findElement(By.cssSelector("button[aria-label=\"close\"]"));
        youtubeClose.click();

        delayQuit();

    }
}