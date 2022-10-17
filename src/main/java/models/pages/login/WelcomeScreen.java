package models.pages.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.component.login.LanguageComponent;
import models.component.login.SSOLoginHahaloloComponent;
import models.component.login.WelcomeComponent;

public class WelcomeScreen {

    private final AppiumDriver<MobileElement> appiumDriver;

    public WelcomeScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public WelcomeComponent welcomeComponent() {
        return new WelcomeComponent(appiumDriver);
    }

    public LanguageComponent languageComponent() {
        return new LanguageComponent(appiumDriver);
    }

    public SSOLoginHahaloloComponent ssoLoginHahaloloComponent() {
        return new SSOLoginHahaloloComponent(appiumDriver);
    }
}
