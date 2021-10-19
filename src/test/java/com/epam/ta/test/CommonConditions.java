package com.epam.ta.test;


import com.epam.ta.driver.SingletonDriver;
import com.epam.ta.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void beforeTest(){
        driver = SingletonDriver.getDriver();
        wait = new WebDriverWait(driver,50);
        driver.manage().window().maximize();
    }

    @AfterMethod (alwaysRun = true)
    public void afterTest(){
        SingletonDriver.closeDriver();
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
