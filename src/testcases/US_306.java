package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

public class US_306 extends BaseDriver {
    @Test
    public void test6() {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement contactUs = driver.findElement(By.xpath("//a[@class='contact']"));
        contactUs.click();

        WebElement name = driver.findElement(By.xpath("//input[@id='sender_name']"));
        name.sendKeys("Andrey");

        WebElement eMail = driver.findElement(By.xpath("//input[@id='sender_email']"));
        eMail.sendKeys("TechnoStudy@gmail.com");

        WebElement subject = driver.findElement(By.xpath("//input[@id='sender_subject']"));
        subject.sendKeys("Book");

        WebElement message = driver.findElement(By.xpath("//textarea[@id='sender_message']"));
        message.sendKeys("message");

        WebElement sendMessageBtn = driver.findElement(By.id("send_message_button"));
        sendMessageBtn.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();

        Assert.assertEquals(alertMessage, "Recaptcha didn't match", "Unexpected alert message received.");
        delayQuit();
    }
}
