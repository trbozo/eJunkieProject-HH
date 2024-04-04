package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class US_302 extends BaseDriver {
    @Test
    public void test2(){

        driver.get("https://shopdemo.e-junkie.com/");

        Assert.assertEquals(driver.getCurrentUrl(), "https://shopdemo.e-junkie.com/",  "URL");

        WebElement ebook= driver.findElement(By.linkText("Ebook"));
        ebook.click();

        WebElement ebookAddToCart= driver.findElement(By.xpath("//button[@class='view_product']"));
        ebookAddToCart.click();

        WebElement iframe= driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        WebElement cart = driver.findElement(By.cssSelector("div[class=\"Fixed-Actions Desktop-Only\"] span"));
        Assert.assertEquals(cart.getText(), "1","Cart :");

        WebElement payDebitCard= driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Payment-Button CC']")));
        payDebitCard.click();

        WebElement payButton= driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        payButton.click();

        WebElement errorMessage= driver.findElement(By.xpath("//span[text()='Invalid Email']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Invalid Email']")));

        Assert.assertTrue(errorMessage.getText().contains("Invalid Email"));
        Assert.assertTrue(errorMessage.getText().contains("Invalid Billing Name"));

       delayQuit();
    }
}
