package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class US_301 extends BaseDriver {
    @Test
    public void test1(){

        driver.get("https://shopdemo.e-junkie.com/");

        Assert.assertEquals(driver.getCurrentUrl(), "https://shopdemo.e-junkie.com/","URL");

        WebElement ebook= driver.findElement(By.linkText("Ebook"));
        ebook.click();

        WebElement ebookAddToCart= driver.findElement(By.xpath("//button[@class='view_product']"));
        ebookAddToCart.click();

        WebElement iframe= driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        WebElement cart = driver.findElement(By.cssSelector("div[class=\"Fixed-Actions Desktop-Only\"] span"));
        Assert.assertEquals(cart.getText(), "1","Cart :");

        WebElement addPromoCode= driver.findElement(By.xpath("//button[text()='Add Promo Code']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add Promo Code']")));
        addPromoCode.click();

        WebElement promoCode= driver.findElement(By.xpath("//input[@placeholder='Promo Code']"));
        promoCode.sendKeys("112233");

        WebElement applyButton= driver.findElement(By.xpath("//button[@class='Promo-Apply']"));
        applyButton.click();

        WebElement verificationMessage= driver.findElement(By.xpath("//span[text()='Invalid promo code']"));
        Assert.assertTrue(verificationMessage.getText().contains("Invalid promo code"));

        delayQuit();
    }
}
