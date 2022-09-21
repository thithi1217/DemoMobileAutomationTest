package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseFlow {

    protected final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
}
