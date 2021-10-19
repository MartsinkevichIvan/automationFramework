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

import java.util.List;

public class YopMailPrivatePage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private final String HOMEPAGE_URL = "https://yopmail.com/ru/wm";

    @FindBy(xpath = "//h3[text()='Total Estimated Monthly Cost']/parent::td/following-sibling::td/h3[contains(text(),'USD')]")
    private WebElement totalEstimateCost;

    @FindBy(id = "refresh")
    private WebElement buttonRefresh;

    public YopMailPrivatePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected YopMailPrivatePage openPage() {
        driver.get(HOMEPAGE_URL);
        wait.until(driver -> (  (JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public WebElement getTotalEstimateCost() {
        driver.switchTo().frame("ifmail");
        return wait.until(ExpectedConditions.visibilityOf(totalEstimateCost));
    }

    public YopMailPrivatePage waitForMail() {

        for (int i = 0; i < 100; i++) {
            driver.switchTo().frame("ifmail");
            List<WebElement> letters = driver.findElements(By.xpath("//h3[text()='Total Estimated Monthly Cost']" +
                    "/parent::td/following-sibling::td/h3[contains(text(),'USD')]"));
            driver.switchTo().defaultContent();
            if (letters.size() != 0) {
                logger.info("The letter has come.");
                return this;
            } else {
                try {
                    buttonRefresh.click();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        logger.error("The letter has not come.");
        return this;
    }
}
