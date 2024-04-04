package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utility.BaseDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

public class US_308win extends BaseDriver {

    @Test
    public void test8alt() throws AWTException {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement eCommerceBtn = driver.findElement(By.cssSelector("a[class=\"EJ-ShopLink\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(eCommerceBtn)).click();

        WebElement logo = driver.findElement(By.cssSelector("a[href='/']"));
        wait.until(ExpectedConditions.elementToBeClickable(logo)).click();

        WebElement seeHowItWorksBtn = driver.findElement(By.cssSelector("div[class=\"banner_btn\"] a"));
        wait.until(ExpectedConditions.elementToBeClickable(seeHowItWorksBtn)).click();

        //TODO for Mac
        //************************//

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
        }

        // Focus to the Play button
        Robot robot = new Robot();
        for (int i = 0; i < 15; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.delay(10);
        }

        // Play
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);

        // 10 second
        robot.delay(10000);

        WebElement youtubeClose = driver.findElement(By.cssSelector("button[aria-label=\"close\"]"));
        youtubeClose.click();

        delayQuit();
    }
}
