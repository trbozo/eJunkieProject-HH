package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
public class US_307 extends BaseDriver {

    @Test
    public void test7(){

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement eCommerceBtn= driver.findElement(By.cssSelector("a[class=\"EJ-ShopLink\"]"));
        eCommerceBtn.click();

        WebElement logo= driver.findElement(By.cssSelector("a[href='/']"));
        logo.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.e-junkie.com/","URL");
    }
}
