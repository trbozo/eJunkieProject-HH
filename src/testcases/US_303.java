package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class US_303 extends BaseDriver {
    @Test
    public void test3() {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement ebook = driver.findElement(By.linkText("Ebook"));
        ebook.click();

        WebElement ebookAddToCart = driver.findElement(By.xpath("//button[@class='view_product']"));
        ebookAddToCart.click();

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        WebElement payDebitCard = driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Payment-Button CC']")));
        payDebitCard.click();

        WebElement email = driver.findElement(By.cssSelector("input[placeholder=\"Email\"]"));
        email.sendKeys("test@gmail.com");

        WebElement emailConfirm = driver.findElement(By.cssSelector("input[placeholder=\"Confirm Email\"]"));
        emailConfirm.sendKeys("test@gmail.com");

        WebElement nameOnCard = driver.findElement(By.cssSelector("input[placeholder=\"Name On Card\"]"));
        nameOnCard.sendKeys("Andrey Jackson");

        WebElement phone = driver.findElement(By.cssSelector("p[class=\"Billing-Phone Inline\"] input"));
        phone.sendKeys("123456789");

        WebElement company = driver.findElement(By.cssSelector("p[class=\"Billing-Company\"] input"));
        company.sendKeys("Techno Study");

        WebElement frameChild = driver.findElement(By.xpath("//iframe[@title='Güvenli kart ödeme giriş çerçevesi']"));
        driver.switchTo().frame(frameChild);

        WebElement cardNumber = driver.findElement(By.cssSelector("input[name='cardnumber']"));
        cardNumber.sendKeys("1111 1111 1111 1111");

        driver.switchTo().defaultContent();

        WebElement iframeElement = driver.findElement(By.xpath("//iframe[contains(@class, 'EJIframeV3')]"));
        driver.switchTo().frame(iframeElement);

        WebElement errorMessage = driver.findElement(By.xpath("//span[contains(text(), 'Kart numaranız geçersiz.')]"));
        System.out.println("Error Message: " + errorMessage.getText());

        driver.switchTo().defaultContent();

        delayQuit();
    }
}
