package test_flows.login;

import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.component.login.LanguageComponent;
import models.component.login.SSOLoginHahaloloComponent;
import models.component.login.WelcomeComponent;
import models.pages.login.WelcomeScreen;
import org.testng.asserts.SoftAssert;
import test_data.DataObjectBuilder;
import test_data.models.LanguageData;
import test_flows.BaseFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WelcomeFlow extends BaseFlow {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final String expectedHiTextStr = "Hi there!";
    private final String expectedQuestionTextStr = "Which account do you want to use? HAHALOLO or anonymous account?";
    private final String expectedLoginHHLLBtnLabel = "Log in with Hahalolo";
    private final String expectedLoginAnonymouslyBtnLabel = "Log in Anonymously";
    private final String expectedCountryTxtStr = "English";
    private final String expectedLanguageTxtStr = "Language";
    private final String expectediOSLanguageTitleTxtStr = "Select a language";
    private final String expectedAndLanguageTitleTxtStr = "Language";
    private final String fileLanguageDataPath = "/src/main/java/test_data/login/Language.json";

    public WelcomeFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }

    @Step("Verify Welcome screen is displayed correctly")
    public void verifyUI() {
        WelcomeScreen welcomeScreen = new WelcomeScreen(appiumDriver);
        WelcomeComponent welcomeComponent = welcomeScreen.welcomeComponent();
        verifyHiTxtStr(welcomeComponent);
        verifyQuestionTxtStr(welcomeComponent);
        verifyLoginHHLLBtn(welcomeComponent);
        verifyLoginAnonymouslyBtn(welcomeComponent);
        verifyCountryTxtStr(welcomeComponent);
        verifyLanguageTxtStr(welcomeComponent);
    }

    @Step("Verify navigate to Login with Hahalolo screen")
    public void verifyNavToLoginHHLL() {
        WelcomeScreen welcomeScreen = new WelcomeScreen(appiumDriver);
        SSOLoginHahaloloComponent ssoLoginHahaloloComponent = welcomeScreen.ssoLoginHahaloloComponent();
    }

    @Step("Verify navigate to Language modal")
    public void verifyNavToLanguageModal() {
        WelcomeScreen welcomeScreen = new WelcomeScreen(appiumDriver);
        LanguageComponent languageComponent = welcomeScreen.languageComponent();

        String actualLanguageTitleTextStr = languageComponent.getTitleTxtStr();
        SoftAssert softAssert = new SoftAssert();
        if (Platforms.valueOf(appiumDriver.getPlatformName()) == Platforms.ios) {
            softAssert.assertEquals(actualLanguageTitleTextStr, expectediOSLanguageTitleTxtStr, "[ERR] Language title is incorrect");
        } else {
            softAssert.assertEquals(actualLanguageTitleTextStr, expectedAndLanguageTitleTxtStr, "[ERR] Language title is incorrect");
        }
        softAssert.assertAll();
        languageComponent.clickOnCancelBtn();
    }

    public void verifyLanguageBtn() {
        WelcomeScreen welcomeScreen = new WelcomeScreen(appiumDriver);
        WelcomeComponent welcomeComponent = new WelcomeComponent(appiumDriver);
        LanguageComponent languageComponent = welcomeScreen.languageComponent();

        // Not English, choose English
//        if (!welcomeComponent.getCountryTxtStr().equals(DEFAULT_LANGUAGE)) {
//            languageComponent.selectRandomCountry(DEFAULT_LANGUAGE);
//        }

        // Get actual country list
        List<String> actualCountryList = languageComponent.getListCountry();

        // Get expected country list
        LanguageData[] languageData = DataObjectBuilder.buildDataObject(fileLanguageDataPath, LanguageData[].class);
        List<String> expectedLanguageList = new ArrayList<>();
        for (LanguageData expectedLang : languageData) {
            expectedLanguageList.add(expectedLang.getLabel());
        }

        // Compare data, print different country from actual list
        actualCountryList.removeAll(expectedLanguageList);
        System.out.println(actualCountryList);

        // TODO: select English again
//        languageComponent.selectRandomCountry(getRandomCountry(actualCountryList));
        languageComponent.clickOnCancelBtn();
    }

    @Step("Check Hi there! text is displayed correctly")
    private void verifyHiTxtStr(WelcomeComponent welcomeComponent) {
        String actualHiTextStr = welcomeComponent.getHiTxtStr();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualHiTextStr, expectedHiTextStr, "[ERR] Hi there str is incorrect");
        softAssert.assertAll();
    }

    @Step("Check Introduce text is displayed correctly")
    private void verifyQuestionTxtStr(WelcomeComponent welcomeComponent) {
        String actualQuestionTextStr = welcomeComponent.getQuestionTxtStr();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualQuestionTextStr, expectedQuestionTextStr, "[ERR] Question str is incorrect");
        softAssert.assertAll();
    }

    @Step("Check Login Hahalolo button is existed")
    private void verifyLoginHHLLBtn(WelcomeComponent welcomeComponent) {
        boolean isLoginHHLLBtnEnable = welcomeComponent.loginHHLLBtnElem.isEnabled();
        String actualLoginHHLLBtnLabel = welcomeComponent.loginHHLLBtnElem.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isLoginHHLLBtnEnable, "[ERR] Login HAHALOLO button is not enable");
        softAssert.assertEquals(actualLoginHHLLBtnLabel, expectedLoginHHLLBtnLabel, "[ERR] Login Hahalolo button is incorrect name");
        softAssert.assertAll();
    }

    @Step("Check Login Anonymously button is existed")
    private void verifyLoginAnonymouslyBtn(WelcomeComponent welcomeComponent) {
        boolean isLoginAnonymouslyBtnEnable = welcomeComponent.loginAnonymouslyBtnElem.isEnabled();
        String actualLoginAnonymouslyBtnLabel = welcomeComponent.loginAnonymouslyBtnElem.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isLoginAnonymouslyBtnEnable, "[ERR] Login Anonymously button is not enable");
        softAssert.assertEquals(actualLoginAnonymouslyBtnLabel, expectedLoginAnonymouslyBtnLabel, "[ERR] Login Anonymously button is incorrect name");
        softAssert.assertAll();
    }

    @Step("Check Country text is displayed correctly")
    private void verifyCountryTxtStr(WelcomeComponent welcomeComponent) {
        String actualCountryTxtStr = welcomeComponent.getCountryTxtStr();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualCountryTxtStr, expectedCountryTxtStr, "[ERR] Country str is incorrect");
        softAssert.assertAll();
    }

    @Step("Check Language text is displayed correctly")
    private void verifyLanguageTxtStr(WelcomeComponent welcomeComponent) {
        String actualLanguageTxtStr = welcomeComponent.languageTxtElem.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualLanguageTxtStr, expectedLanguageTxtStr, "[ERR] Language button is incorrect name");
        softAssert.assertAll();
    }


    private String getRandomCountry(List<String> countryList) {
        Random random = new Random();
        String randomElem = countryList.get(random.nextInt(countryList.size()));

        return randomElem;
    }
}
