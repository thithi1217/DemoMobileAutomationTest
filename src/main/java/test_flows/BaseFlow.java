package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.pages.login.WelcomeScreen;

public class BaseFlow {

    protected final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Go to SSO Hahalolo screen")
    public void goToSSOLoginHHLLScreen() {
        new WelcomeScreen(appiumDriver).welcomeComponent().clickOnLoginHHLLBtn();
    }

    @Step("Go to Login Anonymously Screen")
    public void goToLoginAnonymouslyScreen() {
        new WelcomeScreen(appiumDriver).welcomeComponent().clickOnLoginAnonymouslyBtn();
    }

    @Step("Go to Language modal")
    public void goToLanguageModal() {
        new WelcomeScreen(appiumDriver).welcomeComponent().clickOnLanguageBtn();
    }
}
