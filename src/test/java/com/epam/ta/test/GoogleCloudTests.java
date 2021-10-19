package com.epam.ta.test;


import com.epam.ta.model.Computer;
import com.epam.ta.page.googleCloudPages.CalculatorCountResultPage;
import com.epam.ta.page.googleCloudPages.CalculatorEmailPage;
import com.epam.ta.page.googleCloudPages.CloudGoogleHomePage;
import com.epam.ta.page.googleCloudPages.YopMailHomePage;
import com.epam.ta.service.CompCreator;
import com.epam.ta.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudTests extends CommonConditions {

    @Test
    public void hardcoreTest() {

        Computer computer = CompCreator.createProductComputerEngine();
        CalculatorCountResultPage calculatorCountResultPage = new CloudGoogleHomePage(driver)
                .openPage()
                .searchForTerms("Google Cloud Platform Pricing Calculator")
                .openLinkToSearchTerm()
                .activateSectionComputerEngine()
                .setNumberOfInstances(computer)
                .chooseOperatingSystem(computer)
                .chooseMachineCLass(computer)
                .chooseSeries(computer)
                .chooseMachineType(computer)
                .chooseNumberOfGpu(computer)
                .chooseTypeOfGpu(computer)
                .chooseLocalSsd(computer)
                .chooseDataCenter(computer)
                .chooseCommittedUsage(computer)
                .estimateCalculationResult();
        String totalEstimateCostInCalculator = calculatorCountResultPage.getTotalEstimatedCostPerMonth().getText()
                .replace("Total Estimated Cost: USD", "")
                .replace("per 1 month", "").trim();

        Utils.openNewTab(driver);
        Utils.switchToTabByIndex(driver, 1);
        YopMailHomePage yopMailPage = new YopMailHomePage(driver).openPage();
        String generatedEmail = yopMailPage.generateEmail();
        Utils.switchToTabByIndex(driver, 0);
        CalculatorEmailPage emailForm = calculatorCountResultPage.openSendingToEmailForm();
        emailForm.sendCalculationToEmail(generatedEmail);
        Utils.switchToTabByIndex(driver, 1);
        String totalEstimateCostInLetter = yopMailPage.checkMail().waitForMail().getTotalEstimateCost().getText()
                .replace("USD", "").trim();
        Assert.assertEquals(totalEstimateCostInLetter, totalEstimateCostInCalculator);
    }
}
