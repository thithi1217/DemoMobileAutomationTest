package models.component.login;

import context.SwitchContext;
import context.WaitMoreThanOneContext;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import models.pages.login.WelcomeScreen;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomeComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    public WelcomeComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/start_tv")
    @iOSXCUITFindBy(accessibility = "Hi there!")
    public MobileElement hiTxtElem;

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/caption_tv")
    @iOSXCUITFindBy(accessibility = "Which account do you want to use? HAHALOLO or anonymous account?")
    public MobileElement questionTxtElem;

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/hahalolo_bt")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Log in with Hahalolo\"`]")
    public MobileElement loginHHLLBtnElem;

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/incognito_bt")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Log in Anonymously\"`]")
    public MobileElement loginAnonymouslyBtnElem;


    @AndroidFindBy(id = "com.hahalolo.android.halome:id/lang_tv")
    @iOSXCUITFindBy(accessibility = "English")
    public MobileElement countryTxtElem;

    @AndroidFindBy(xpath = "//*[@text=\"Language\"]")
    @iOSXCUITFindBy(accessibility = "Language")
    public MobileElement languageTxtElem;

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/language_wr")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[3]")
    public MobileElement languageBtnElem;

    @Step("Get Hi there! text")
    public String getHiTxtStr() {
        return hiTxtElem.getText().trim();
    }

    @Step("Get Introduce text")
    public String getQuestionTxtStr() {
        return questionTxtElem.getText().trim();
    }

    @Step("Click on Login Hahalolo button")
    public void clickOnLoginHHLLBtn() {
        loginHHLLBtnElem.click();
    }

    @Step("Click on Login Anonymously button")
    public void clickOnLoginAnonymouslyBtn() {
        loginAnonymouslyBtnElem.click();
    }


    @Step("Get Country's name text")
    public String getCountryTxtStr() {
        return countryTxtElem.getText().trim();
    }

    @Step("Get Language text")
    public String getLanguageTxtStr() {
        return languageTxtElem.getText().trim();
    }

    @Step("Click on Language button")
    public void clickOnLanguageBtn() {
        languageBtnElem.click();
    }
}
