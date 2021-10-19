package com.epam.ta.page.googleCloudPages;


import com.epam.ta.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CloudGoogleHomePage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//button[@class='button button-white devsite-suggest-all-results']")
    private WebElement btnSearch;

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInput;

    public CloudGoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        logger.info("Open homepage of Cloud google.");
        wait.until(driver -> (  (JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public CloudGoogleSearchResultPage searchForTerms(String term) {
        searchInput.click();
        searchInput.sendKeys(term);
        wait.until(ExpectedConditions.visibilityOf(btnSearch)).click();
        wait.until(driver -> ((JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete"));
        logger.info("Search for '"+term+"'.");
        return new CloudGoogleSearchResultPage(driver);
    }
}
