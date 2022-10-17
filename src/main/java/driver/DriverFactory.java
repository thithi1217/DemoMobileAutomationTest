package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx{

    private AppiumDriver<MobileElement> appiumDriver;

    public AppiumDriver<MobileElement> getDriver(Platforms platform, String udid, String systemPort, String platformVersion) {

        if (appiumDriver == null) {
            if (platform == null) {
                throw new IllegalArgumentException("Platform can't be null, you can provide one of these: "
                        + Arrays.toString(Platforms.values()));
            }

            Exception exception = null;

            try {
                // Desired Capabilities
                DesiredCapabilities desiredCaps = new DesiredCapabilities();
                desiredCaps.setCapability(PLATFORM_NAME, platform);

                // Init appium session
//                URL targetServer = new URL("http://10.1.1.92:4444/wd/hub");
                URL targetServer = new URL("http://localhost:4723/wd/hub");
                String hubEnvVar = System.getProperty("hub");
                String hubUrl = hubEnvVar != null ? hubEnvVar : System.getenv("hub");
                if(hubUrl != null) {
                    System.out.println("[INFO] Running test in remote mode!");
                    targetServer = new URL(hubUrl + ":4444/wd/hub");
                }

                switch (platform) {
                    case android:
                        desiredCaps.setCapability(AUTOMATION_NAME, "uiautomator2");
                        desiredCaps.setCapability(UDID, udid);
                        desiredCaps.setCapability(APP_PACKAGE, "com.hahalolo.android.halome");
                        desiredCaps.setCapability(APP_ACTIVITY, "com.halo.presentation.startapp.start.StartAct");
                        desiredCaps.setCapability(SYSTEM_PORT, Integer.parseInt(systemPort));
                        desiredCaps.setCapability(LANGUAGE, "en");
                        desiredCaps.setCapability(LOCALE, "en");
                        appiumDriver = new AndroidDriver<>(targetServer, desiredCaps);
                        break;
                    case ios:
                        desiredCaps.setCapability(AUTOMATION_NAME, "XCUITest");
                        desiredCaps.setCapability(DEVICE_NAME, udid); //iPhone 12ßß
                        desiredCaps.setCapability(PLATFORM_VERSION, platformVersion); // 15.0 NOT 15.1.2
                        desiredCaps.setCapability(BUNDLE_ID, "com.hahalolo.ios.halome");
                        desiredCaps.setCapability(WDA_LOCAL_PORT, Integer.parseInt(systemPort));
                        desiredCaps.setCapability(LANGUAGE, "en");
                        desiredCaps.setCapability(LOCALE, "en");
                        appiumDriver = new IOSDriver<>(targetServer, desiredCaps);
                }

            } catch (Exception e) {
                exception = e;
            }

            if (appiumDriver == null) {
                throw new RuntimeException(exception.getMessage());
            }

            // Add IMPLICIT WAIT
            appiumDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        }
        return appiumDriver;
    }

    public void quitAppiumDriver(){
        if (appiumDriver != null){
            appiumDriver.quit();
            appiumDriver = null;
        }

    }
}
