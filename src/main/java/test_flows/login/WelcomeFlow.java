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

    public void welcome() {

    }

    @Step("Verify Hi there text")
    public void verifyHiTxtStr() {
        WelcomeScreen welcomeScreen = new WelcomeScreen(appiumDriver);
        WelcomeComponent welcomeComponent = welcomeScreen.welcomeComponent();
        String actualHiTextStr = welcomeComponent.getHiTxtStr();
        String expectedHiTextStr = "Hi there!";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualHiTextStr, expectedHiTextStr, "[ERR] Hi there str is incorrect");
        softAssert.assertAll();
    }

    @Step("Verify Question text")
    public void verifyQuestionTxtStr() {
        WelcomeScreen welcomeScreen = new WelcomeScreen(appiumDriver);
        WelcomeComponent welcomeComponent = welcomeScreen.welcomeComponent();
        String actualQuestionTextStr = welcomeComponent.getQuestionTxtStr();
        String expectedQuestionTextStr = "Which account do you want to use? HAHALOLO or anonymous account?";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualQuestionTextStr, expectedQuestionTextStr, "[ERR] Question str is incorrect");
        softAssert.assertAll();
    }

    public void verifyLoginHHLLBtn() {
        WelcomeScreen welcomeScreen = new WelcomeScreen(appiumDriver);
        WelcomeComponent welcomeComponent = welcomeScreen.welcomeComponent();
        boolean isLoginHHLLBtnDisplay = welcomeComponent.loginHHLLBtnElem.isDisplayed();
        boolean isLoginHHLLBtnEnable = welcomeComponent.loginHHLLBtnElem.isEnabled();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isLoginHHLLBtnDisplay, "[ERR] Login HAHALOLO button is not displayed");
        softAssert.assertTrue(isLoginHHLLBtnEnable, "[ERR] Login HAHALOLO button is not enable");
        softAssert.assertAll();
    }

    public void verifyLoginAnonymouslyBtn() {
        WelcomeScreen welcomeScreen = new WelcomeScreen(appiumDriver);
        WelcomeComponent welcomeComponent = welcomeScreen.welcomeComponent();
        boolean isLoginAnonymouslyBtnDisplay = welcomeComponent.loginAnonymouslyBtnElem.isDisplayed();
        boolean isLoginAnonymouslyBtnEnable = welcomeComponent.loginAnonymouslyBtnElem.isEnabled();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isLoginAnonymouslyBtnDisplay, "[ERR] Login Anonymously button is not displayed");
        softAssert.assertTrue(isLoginAnonymouslyBtnEnable, "[ERR] Login Anonymously button is not enable");
        softAssert.assertAll();
    }
}
