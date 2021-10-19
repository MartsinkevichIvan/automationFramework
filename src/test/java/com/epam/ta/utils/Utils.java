package com.epam.ta.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static String getTextOfRootElement(WebElement rootElement) {
        String textValue = rootElement.getText().trim();
        List<WebElement> children = rootElement.findElements(By.xpath("./*"));
        for (WebElement child : children) {
            textValue = textValue.replaceFirst(child.getText(), "").trim();
        }
        return textValue;
    }

    public static void switchToTabByIndex(WebDriver driver, int index) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    public static void openNewTab(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
    }
}
