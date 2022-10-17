package context;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.Set;

public class SwitchContext {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final Integer NATIVE_CONTEXT_INDEX = 0;
    private final Integer WEBVIEW_CONTEXT_INDEX = 1;

    public SwitchContext(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void switchToNativeContext() {
        Set<String> contextNames = appiumDriver.getContextHandles();
        appiumDriver.context((String) contextNames.toArray()[NATIVE_CONTEXT_INDEX]);
    }

    public void switchToWebViewContext() {
        Set<String> contextNames = appiumDriver.getContextHandles();
        appiumDriver.context((String) contextNames.toArray()[WEBVIEW_CONTEXT_INDEX]);
    }
}
