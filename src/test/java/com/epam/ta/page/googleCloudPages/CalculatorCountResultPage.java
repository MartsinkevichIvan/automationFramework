package com.epam.ta.page.googleCloudPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.epam.ta.page.AbstractPage;

public class CalculatorCountResultPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private final String HOMEPAGE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(),'VM class')]")
    private WebElement valueOfVMClass;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex' " +
            "and contains(text(),'Instance type:')]")
    private WebElement valueOfInstanceType;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(),'Region:')]")
    private WebElement valueOfRegion;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex' and contains(text(),'Local SSD:')]")
    private WebElement valueOfLocalSSD;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(),'Commitment term:')]")
    private WebElement valueOfCommitmentTerm;

    @FindBy(xpath = "//b[@class='ng-binding' and contains(text(),'Total Estimated Cost')]")
    private WebElement valueOfTotalEstimateCostPerMonth;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement btnEmailEstimate;

    public CalculatorCountResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected CalculatorCountResultPage openPage() {
        driver.get(HOMEPAGE_URL);
        wait.until(driver -> (  (JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public WebElement getTotalEstimatedCostPerMonth() {
        return valueOfTotalEstimateCostPerMonth;
    }

    public CalculatorEmailPage openSendingToEmailForm() {
        switchToMyFrame();
        btnEmailEstimate.click();
        logger.info("Open form for send calculating result to email.");
        return new CalculatorEmailPage(driver);
    }

    private void switchToMyFrame() {
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//article[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame(frame);
        WebElement myFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myFrame")));
        driver.switchTo().frame(myFrame);
    }
}
