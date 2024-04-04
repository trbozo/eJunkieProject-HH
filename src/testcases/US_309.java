package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class US_309 extends BaseDriver {

    String name = "James";
    String surName = "Watt";

    @Test
    public void fileDownloadTest() {

        driver.get("https://www.e-junkie.com/wiki/demo/");

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'Add to Cart')]"))));
        addToCartButton.click();
        ////////////////////////////////////////

        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);

        WebElement payButton = driver.findElement(By.xpath("//button[contains(text(),'Pay using Debit / Credit Card')]"));
        payButton.click();

//      Fill in the mandatory fields in Billing Details (Email, Confirm Email, Billing Name, Billing Address 1, Billing City, Billing PostCode):
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        emailField.sendKeys(name + surName + "@example.com");

        WebElement confirmEmailField = driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));
        confirmEmailField.sendKeys(name + surName + "@example.com");

        WebElement nameOnCardField = driver.findElement(By.xpath("//input[@placeholder='Name On Card']"));
        nameOnCardField.sendKeys(name + " " + surName);

        WebElement phoneField = driver.findElement(By.xpath("//input[@placeholder='Optional']"));
        phoneField.sendKeys("123-456-7890");

        WebElement companyField = driver.findElement(By.xpath("//input[@placeholder='Optional']"));
        companyField.sendKeys("ABC Company");

        WebElement address1Field = driver.findElement(By.xpath("//input[@placeholder='Address Line 1']"));
        address1Field.sendKeys("123 Main Street");

        WebElement address2Field = driver.findElement(By.xpath("//input[@placeholder='Optional']"));
        address2Field.sendKeys("Apt 101");

        WebElement cityField = driver.findElement(By.xpath("//input[@placeholder='City']"));
        cityField.sendKeys("Anytown");

        WebElement countryDropdown = driver.findElement(By.xpath("//select[@autocomplete='country']"));
        countryDropdown.sendKeys("United States");

        WebElement stateDropdown = driver.findElement(By.xpath("//select[@autocomplete='state']"));
        stateDropdown.sendKeys("ALABAMA");

        WebElement zipField = driver.findElement(By.xpath("//input[@placeholder='ZIP/Postal Code']"));
        zipField.sendKeys("12345");
        ///////////////////////////////////////////////////

        WebElement cardTypeDropdown = driver.findElement(By.xpath("//p[@class='Card-Type']/select"));
        cardTypeDropdown.sendKeys("Visa");

        WebElement cardNumberInput = driver.findElement(By.cssSelector("p.Card-Number input"));
        cardNumberInput.sendKeys("4242 4242 4242 4242");

        WebElement cardExpiryInput = driver.findElement(By.xpath("//input[@placeholder='MM / YY']"));
        cardExpiryInput.sendKeys("12/24");

        WebElement cvvInput = driver.findElement(By.xpath("//input[@placeholder='000']"));
        cvvInput.sendKeys("123");

        WebElement submitButton = driver.findElement(By.cssSelector("button.Pay-Button"));
        submitButton.click();

        // Verify success message
        WebElement confirmationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.confirme_text")));
        Assert.assertTrue(confirmationElement.getText().contains(name + ", your order is confirmed. Thank you!"));

        /////////////////////////////////////////////////

        driver.findElement(By.linkText("Download")).click();
        delay(10);

        String pdfFilePath = "C:\\Users\\hakan\\Downloads\\demo.pdf"; // PDF dosya yolunu kullandığınız klasöre göre değiştirmelisiniz...
        String expectedText = "James Watt"; // Aradığınız isim

        try {
            File file = new File(pdfFilePath);
            PDDocument pdDoc = PDDocument.load(file);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String pdfText = pdfStripper.getText(pdDoc);

            System.out.println("pdfText = " + pdfText); // CHECKPOINT (Silinebilir...)

            if (pdfText.contains(expectedText)) {
                System.out.println("Metin PDF içinde bulundu.");
            } else {
                System.out.println("Metin PDF içinde bulunamadı.");
            }

            pdDoc.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}