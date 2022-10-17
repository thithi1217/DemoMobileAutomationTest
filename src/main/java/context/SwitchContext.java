package context;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SwitchToWebViewContext {

    private final AppiumDriver<MobileElement> appiumDriver;

    public SwitchToWebViewContext(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void switchToWebViewContext() {

    }
}
