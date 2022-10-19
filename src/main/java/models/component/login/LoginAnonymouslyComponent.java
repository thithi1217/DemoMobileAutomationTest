package models.component.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginAnonymouslyComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    public LoginAnonymouslyComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/icon")
    @iOSXCUITFindBy(accessibility = "m2_auth_phone_head_image")
    public MobileElement phoneHeadImageElem;

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/close_bt")
    @iOSXCUITFindBy(accessibility = "close dark")
    public MobileElement closeBtnElem;

    @Step("Click on Close button")
    public void clickOnCloseBtn() {
        closeBtnElem.click();
    }
}
