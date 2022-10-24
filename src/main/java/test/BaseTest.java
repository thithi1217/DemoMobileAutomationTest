package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.internal.CapabilityHelpers;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.Optional;
import org.testng.annotations.*;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class BaseTest {

    private static final List<DriverFactory> driverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<DriverFactory> driverThread;

    private String udid;
    private String systemPort;
    private String platformName = System.getProperty("platform");
    private String platformVersion;
    private String deviceName;

    @BeforeTest(description = "Init appium session at Before Test")
    @BeforeClass(description = "Init appium session at Before Class")
    @Parameters({"udid", "systemPort", "platformName", "platformVersion", "deviceName"})
    public void initAppiumSession(String udid, String systemPort, String platformName, @Optional("platformVersion") String platformVersion, @Optional("deviceName") String deviceName) {
        System.out.println("I'm running at: " + new GregorianCalendar().getTime().toString());
        System.out.println(udid + " || " + systemPort);
        this.udid = udid;
        this.systemPort = systemPort;
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.deviceName = deviceName;
        driverThread = ThreadLocal.withInitial(()->{
            DriverFactory driverThread = new DriverFactory();
            driverThreadPool.add(driverThread);
            return driverThread;
        });
    }

    @AfterTest(alwaysRun = true, description = "Quit the appium session")
    public void quitAppiumSession() {
        driverThread.get().quitAppiumDriver();
    }

    protected AppiumDriver<MobileElement> getDriver() {
        return driverThread.get().getDriver(Platforms.valueOf(platformName), udid, systemPort, platformVersion, deviceName);
    }

    @AfterMethod(description = "Capture screenshot")
    public void captureScreenshot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // 1. Get the test method name
            String testMethodName = result.getName();

            // 2. Get taken time
            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH) + 1;
            int d = calendar.get(Calendar.DATE);
            int hr = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);
            String dateTaken = y + "-" + m + "-" + d + "-" + hr + "-" + min + "-" + sec;

            // 3. File location with file extension
            AppiumDriver<MobileElement> currentDriverThread = driverThread.get().getDriver(Platforms.valueOf(platformName), udid, systemPort, platformVersion, deviceName);
            Capabilities caps = currentDriverThread.getCapabilities();
            String currentUDID = CapabilityHelpers.getCapability(caps, "udid", String.class);

            String fileLocation = System.getProperty("user.dir") + "/screenshots/" + currentUDID + "-" + testMethodName + "-" + dateTaken + ".png";

            // 4. Save
            File screenshot = currentDriverThread.getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(screenshot, new File(fileLocation));

                // Get file content then attach to allure reporter
                Path screenshotPathContent = Paths.get(fileLocation);

                InputStream inputStream = Files.newInputStream(screenshotPathContent);
                Allure.addAttachment(testMethodName + "-" + dateTaken, inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
