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
    //Icon button back
    @AndroidFindBy(id = "com.hahalolo.android.halome:id/back_bt")
    @iOSXCUITFindBy(accessibility = "back dark")
    public MobileElement backBtnElem;

    //logo ở màn hình xác minh tk
    @AndroidFindBy(id = "com.hahalolo.android.halome:id/app_ic")
    @iOSXCUITFindBy(accessibility = "logo_halome_new")
    public MobileElement logoHalomeElem;

    //avt ở trang xác minh tk
    @AndroidFindBy(id = "com.hahalolo.android.halome:id/avatar_img")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[3]")
    public MobileElement avatarUserElem;

    //avt render
    @AndroidFindBy(id = "com.hahalolo.android.halome:id/avatar_img")
    @iOSXCUITFindBy(accessibility = "TF")
    public MobileElement notAvatarUserElem;


    //tên user ở trang xác minh tk
    @AndroidFindBy(id = "com.hahalolo.android.halome:id/username_tv")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[1]")
    public MobileElement usernameElem;


    //button Tiếp tục ở trang xác minh tk
    @AndroidFindBy(id = "com.hahalolo.android.halome:id/next_bt")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continue\"`]")
    public MobileElement continueBtnElem;


    //Link button "Không phải bạn..."
    @AndroidFindBy(id = "com.hahalolo.android.halome:id/wrong_account_tv")
    @iOSXCUITFindBy(accessibility = "Not you? Tap here to change your account")
    public MobileElement tapHereLinkElem;

    @Step("Click on Back button")
    public void clickOnBackBtn() {
        backBtnElem.click();
    }
}
