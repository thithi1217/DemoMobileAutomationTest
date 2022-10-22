package models.component.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginWithHahaloloComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    public LoginWithHahaloloComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/close_bt")
    @iOSXCUITFindBy(accessibility = "back dark")
    public MobileElement backBtnElem;

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/close_bt")
    @iOSXCUITFindBy(accessibility = "logo_halome_new")
    public MobileElement logoHalomeElem;

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/close_bt")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[3]")
    public MobileElement avatarUserElem;

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/close_bt")
    @iOSXCUITFindBy(accessibility = "TF")
    public MobileElement notAvatarUserElem;

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/close_bt")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[1]")
    public MobileElement usernameElem;

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/close_bt")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continue\"`]")
    public MobileElement continueBtnElem;

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/close_bt")
    @iOSXCUITFindBy(accessibility = "Not you? Tap here to change your account")
    public MobileElement tapHereLinkElem;

    @Step("Click on Back button")
    public void clickOnBackBtn() {
        backBtnElem.click();
    }
}
