package context;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchContext {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final Integer NATIVE_CONTEXT_INDEX = 0;
    private final Integer WEBVIEW_CONTEXT_INDEX = 1;

    public SwitchContext(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void switchToNativeContext() {
        Set<String> contextNames = setContextHandles();
        appiumDriver.context((String) contextNames.toArray()[NATIVE_CONTEXT_INDEX]);
    }

    public void switchToWebViewContext() {
        Set<String> contextNames = setContextHandles();
        appiumDriver.context((String) contextNames.toArray()[WEBVIEW_CONTEXT_INDEX]);
    }

    private Set<String> setContextHandles() {
        // Wait until we have more than one context
        WebDriverWait wait = new WebDriverWait(appiumDriver, 15L);
        wait.until(new WaitMoreThanOneContext(appiumDriver));

        // TODO: Trying to find other option waiting page SSO load
        try {
            // Wait web sso load
            Thread.sleep(6000);
        } catch (Exception ignored) {
        }

        // Get all contexts
        Set<String> contextNames = appiumDriver.getContextHandles();
        return contextNames;
    }
}
