package test_flows.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import models.component.login.WelcomeComponent;
import models.pages.login.WelcomeScreen;
import org.testng.asserts.SoftAssert;
import test_flows.BaseFlow;

import java.lang.ref.SoftReference;

public class WelcomeFlow extends BaseFlow {

    private final AppiumDriver<MobileElement> appiumDriver;

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
        verifyLanguageTxtStr(welcomeComponent);
        verifyLanguageBtn(welcomeComponent);
    }

    @Step("Check Hi there! text is displayed correctly")
    private void verifyHiTxtStr(WelcomeComponent welcomeComponent) {
        String actualHiTextStr = welcomeComponent.getHiTxtStr();
        String expectedHiTextStr = "Hi there!";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualHiTextStr, expectedHiTextStr, "[ERR] Hi there str is incorrect");
        softAssert.assertAll();
    }

    @Step("Check Introduce text is displayed correctly")
    private void verifyQuestionTxtStr(WelcomeComponent welcomeComponent) {
        String actualQuestionTextStr = welcomeComponent.getQuestionTxtStr();
        String expectedQuestionTextStr = "Which account do you want to use? HAHALOLO or anonymous account?";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualQuestionTextStr, expectedQuestionTextStr, "[ERR] Question str is incorrect");
        softAssert.assertAll();
    }

    @Step("Check Login Hahalolo button is existed")
    private void verifyLoginHHLLBtn(WelcomeComponent welcomeComponent) {
        boolean isLoginHHLLBtnEnable = welcomeComponent.loginHHLLBtnElem.isEnabled();
        String actualLoginHHLLBtnLabel = welcomeComponent.loginHHLLBtnElem.getText();
        String expectedLoginHHLLBtnLabel = "Log in with Hahalolo";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isLoginHHLLBtnEnable, "[ERR] Login HAHALOLO button is not enable");
        softAssert.assertEquals(actualLoginHHLLBtnLabel, expectedLoginHHLLBtnLabel, "[ERR] Login Hahalolo button is incorrect name");
        softAssert.assertAll();
    }

    @Step("Check Login Anonymously button is existed")
    private void verifyLoginAnonymouslyBtn(WelcomeComponent welcomeComponent) {
        boolean isLoginAnonymouslyBtnEnable = welcomeComponent.loginAnonymouslyBtnElem.isEnabled();
        String actualLoginAnonymouslyBtnLabel = welcomeComponent.loginAnonymouslyBtnElem.getText();
        String expectedLoginAnonymouslyBtnLabel = "Log in Anonymously";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isLoginAnonymouslyBtnEnable, "[ERR] Login Anonymously button is not enable");
        softAssert.assertEquals(actualLoginAnonymouslyBtnLabel, expectedLoginAnonymouslyBtnLabel, "[ERR] Login Anonymously button is incorrect name");
        softAssert.assertAll();
    }

    @Step("Check Country text is displayed correctly")
    private void verifyLanguageTxtStr(WelcomeComponent welcomeComponent) {
        String actualLanguageTxtStr = welcomeComponent.getLanguageTxtStr();
        String expectedLanguageTxtStr = "English";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualLanguageTxtStr, expectedLanguageTxtStr, "[ERR] Country str is incorrect");
        softAssert.assertAll();
    }

    @Step("Check Language button is existed")
    private void verifyLanguageBtn(WelcomeComponent welcomeComponent) {
        boolean isLanguageBtnEnable = welcomeComponent.languageBtnElem.isEnabled();
        String actualLanguageBtnLabel = welcomeComponent.languageBtnElem.getText();
        String expectedLanguageBtnLabel = "Language";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isLanguageBtnEnable, "[ERR] Language button is not enable");
        softAssert.assertEquals(actualLanguageBtnLabel, expectedLanguageBtnLabel, "[ERR] Language button is incorrect name");
        softAssert.assertAll();
    }
}
