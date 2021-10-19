package com.epam.ta.page.googleCloudPages;

import com.epam.ta.model.Computer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.epam.ta.page.AbstractPage;

public class CalculatorHomePage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    public Computer computer;

    private static final String XPATH_OPERATING_SYSTEM_VALUE = "//md-select-menu//div[contains(text(),'%s')]";
    private static final String XPATH_MACHINE_CLASS_VALUE =
            "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'%s')]";
    private static final String XPATH_SERIES_VALUE= "//md-option/div[contains(text(),'%s')]";
    private static final String XPATH_MACHINE_TYPE_VALUE= "//div[contains(text(),'%s')]";
    private static final String XPATH_NUMBER_OF_GPU_VALUE=
            "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'%s')]";
    private static final String XPATH_TYPE_OF_GPU_VALUE="//md-option/div[contains(text(),'%s')]";
    private static final String XPATH_LOCAL_SSD_VALUE="//md-option//div[contains(text(),'%s')]";
    private static final String XPATH_DATACENTER_LOCATION_VALUE=
            "//md-select-menu[@class='md-overflow']//md-option/div[contains(text(),'%s')]";
    private static final String XPATH_COMMITED_USAGE_VALUE=
            "//div[@class='md-select-menu-container md-active md-clickable']//div[text()='%s']";

    private final String HOMEPAGE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//md-tab-item//div[contains(@title, 'Compute Engine')]//div[@class='hexagon-in2']")
    private WebElement btnComputeEngine;

    @FindBy(xpath = "//label[contains(text(),'Number of instances')]/following-sibling::input")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//label[text()='Operating System / Software']/following-sibling::md-select")
    private WebElement operatingSystemDropDown;

    @FindBy(xpath = "//label[text()='Machine Class']/parent::md-input-container/md-select")
    private WebElement machineClassDropDown;

    @FindBy(name = "series")
    private WebElement seriesDropDown;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineTypeDropDown;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-checkbox[@aria-label='Add GPUs']")
    private WebElement checkBoxAddGPUs;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement countOfGPUsDropDown;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement typeOfGPUDropDown;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSDDropDown;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement datacenterLocationDropDown;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement commitedUsageDropDown;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@aria-label='Add to Estimate']")
    private WebElement btnAddToEstimate;

    public CalculatorHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected CalculatorHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        wait.until(driver -> (  (JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public CalculatorHomePage activateSectionComputerEngine() {
        switchToMyFrame();
        wait.until(ExpectedConditions.elementToBeClickable(btnComputeEngine)).click();
        driver.switchTo().defaultContent();
        logger.info("Set section computer engine active.");
        return this;
    }

    public CalculatorHomePage setNumberOfInstances(Computer computer){
        switchToMyFrame();
        numberOfInstances.sendKeys(computer.getNumberOfInstances());
        return this;
    }

    public CalculatorHomePage chooseOperatingSystem(Computer computer){
        operatingSystemDropDown.click();
        waitForElementToBeClickableBy(By.xpath(String.format(XPATH_OPERATING_SYSTEM_VALUE,computer.getOperatingSystem()))).click();
        return this;
    }

    public CalculatorHomePage chooseMachineCLass(Computer computer){
        machineClassDropDown.click();
        waitForElementToBeClickableBy(By.xpath(String.format(XPATH_MACHINE_CLASS_VALUE,computer.getMachineClass()))).click();
        return this;
    }

    public CalculatorHomePage chooseSeries(Computer computer){
        seriesDropDown.click();
        waitForElementToBeClickableBy(By.xpath(String.format(XPATH_SERIES_VALUE,computer.getSeries()))).click();
        return this;
    }

    public CalculatorHomePage chooseMachineType(Computer computer){
        machineTypeDropDown.click();
        waitForElementToBeClickableBy(By.xpath(String.format(XPATH_MACHINE_TYPE_VALUE,computer.getMachineType()))).click();
        return this;
    }

    public CalculatorHomePage chooseNumberOfGpu(Computer computer){
        checkBoxAddGPUs.click();
        countOfGPUsDropDown.click();
        waitForElementToBeClickableBy(By.xpath(String.format(XPATH_NUMBER_OF_GPU_VALUE,computer.getNumberOfGpu()))).click();
        return this;
    }

    public CalculatorHomePage chooseTypeOfGpu(Computer computer){
        typeOfGPUDropDown.click();
        waitForElementToBeClickableBy(By.xpath(String.format(XPATH_TYPE_OF_GPU_VALUE,computer.getGpuType()))).click();
        return this;
    }

    public CalculatorHomePage chooseLocalSsd(Computer computer){
        localSSDDropDown.click();
        waitForElementToBeClickableBy(By.xpath(String.format(XPATH_LOCAL_SSD_VALUE,computer.getLocalSsd()))).click();
        return this;
    }

    public CalculatorHomePage chooseDataCenter(Computer computer){
        datacenterLocationDropDown.click();
        waitForElementToBeClickableBy(
                By.xpath(String.format(XPATH_DATACENTER_LOCATION_VALUE,computer.getDatacenterLocation()))).click();
        return this;
    }

    public CalculatorHomePage chooseCommittedUsage(Computer computer){
        commitedUsageDropDown.click();
        waitForElementToBeClickableBy(By.xpath(String.format(XPATH_COMMITED_USAGE_VALUE,computer.getCommitedUsage()))).click();
        return this;
    }

    public CalculatorCountResultPage estimateCalculationResult(){
        wait.until(ExpectedConditions.visibilityOf(btnAddToEstimate)).click();
        logger.info("Calculating filled functions of computer engine");
        return new CalculatorCountResultPage(driver);
    }

    private void switchToMyFrame() {
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//article[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame(frame);
        WebElement myFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myFrame")));
        driver.switchTo().frame(myFrame);
    }
}
