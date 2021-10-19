package com.epam.ta.page.googleCloudPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.epam.ta.page.AbstractPage;

public class CloudGoogleSearchResultPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private final String HOMEPAGE_URL = "https://cloud.google.com/s/results";

    @FindBy(xpath = "//div/a[contains(@href, 'https://cloud.google.com/products/calculator')]")
    private WebElement calculatorResult;

    private String searchTerm;

    public CloudGoogleSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorHomePage openLinkToSearchTerm() {
        wait.until(ExpectedConditions.visibilityOf(calculatorResult)).click();
        wait.until(driver -> ((JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete"));
        logger.info("Open found page for a search query.");
        return new CalculatorHomePage(driver);
    }

    @Override
    protected CloudGoogleSearchResultPage openPage() {
        driver.get(HOMEPAGE_URL);
        wait.until(driver -> (  (JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete"));
        return this;
    }
}
