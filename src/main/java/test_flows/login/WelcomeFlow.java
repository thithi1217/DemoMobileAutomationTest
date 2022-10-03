package test_flows.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.component.login.LanguageComponent;
import models.component.login.WelcomeComponent;
import models.pages.login.WelcomeScreen;
import org.testng.asserts.SoftAssert;
import test_data.DataObjectBuilder;
import test_data.models.LanguageData;
import test_flows.BaseFlow;

import java.util.ArrayList;
import java.util.List;

public class WelcomeFlow extends BaseFlow {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final String expectedHiTextStr = "Hi there!";
    private final String expectedQuestionTextStr = "Which account do you want to use? HAHALOLO or anonymous account?";
    private final String expectedLoginHHLLBtnLabel = "Log in with Hahalolo";
    private final String expectedLoginAnonymouslyBtnLabel = "Log in Anonymously";
    private final String expectedCountryTxtStr = "English";
    private final String expectedLanguageTxtStr = "Language";
    private final String fileLanguageDataPath = "/src/main/java/test_data/login/Language.json";

    public WelcomeFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }

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

    public void verifyLanguageBtn() {
        WelcomeScreen welcomeScreen = new WelcomeScreen(appiumDriver);
        LanguageComponent languageComponent = welcomeScreen.languageComponent();

        // TODO: compare data from two list
        List<String> actualCountryList = languageComponent.getListCountry();

        LanguageData[] languageData = DataObjectBuilder.buildDataObject(fileLanguageDataPath, LanguageData[].class);
        List<String> expectedLanguageList = new ArrayList<>();

        for (LanguageData expectedLang : languageData) {
            expectedLanguageList.add(expectedLang.getLabel());
        }

        for (String s : expectedLanguageList) {
            System.out.println(s);
        }
        System.out.println(expectedLanguageList.size());
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
}
