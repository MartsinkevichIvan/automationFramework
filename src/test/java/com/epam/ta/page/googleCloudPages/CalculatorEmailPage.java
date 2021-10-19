package com.epam.ta.page.googleCloudPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.epam.ta.page.AbstractPage;

public class CalculatorEmailPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private final String HOMEPAGE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement btnSendEmail;

    public CalculatorEmailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CalculatorEmailPage openPage() {
        driver.get(HOMEPAGE_URL);
        wait.until(driver -> ((JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public void sendCalculationToEmail(String email) {
        emailField.sendKeys(email);
        btnSendEmail.click();
        logger.info("Calculating sent result to the email.");
    }
}
