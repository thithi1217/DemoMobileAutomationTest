package common;

import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.List;

public class Keyboard {

//    private final AppiumDriver<MobileElement> appiumDriver;
//
//    public Keyboard(AppiumDriver<MobileElement> appiumDriver) {
//        this.appiumDriver = appiumDriver;
//    }

    public static void pressKey (AppiumDriver<MobileElement> appiumDriver, String key) {
        if (Platforms.valueOf(appiumDriver.getPlatformName()) == Platforms.android)
            return;

        List<MobileElement> keyboardList = appiumDriver.findElementsByName(key);
        if (keyboardList.size() == 0)
            throw new IllegalArgumentException("Cannot get keyboard elements");
        keyboardList.get(0).click();
    }
}
