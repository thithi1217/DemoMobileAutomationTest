package models.pages.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.component.login.LoginWithHahaloloComponent;

public class LoginWithHahaloloScreen {
    private final AppiumDriver<MobileElement> appiumDriver;

    public LoginWithHahaloloScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginWithHahaloloComponent loginWithHahaloloComponent() {
        return new LoginWithHahaloloComponent(appiumDriver);
    }
}
