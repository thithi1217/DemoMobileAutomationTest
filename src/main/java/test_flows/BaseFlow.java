package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.login.WelcomeScreen;

public class BaseFlow {

    protected final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void goToLoginHHLLScreen() {
        new WelcomeScreen(appiumDriver).welcomeComponent().clickOnLoginHHLLBtn();
    }

    public void goToLoginAnonymouslyScreen() {
        new WelcomeScreen(appiumDriver).welcomeComponent().clickOnLoginAnonymouslyBtn();
    }
}
