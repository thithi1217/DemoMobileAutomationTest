package models.component.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class WelcomeComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    public WelcomeComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(id = "")
    @iOSXCUITFindBy(accessibility = "Hi there!")
    public MobileElement hiTxtElem;

    @AndroidFindBy(id = "")
    @iOSXCUITFindBy(accessibility = "Which account do you want to use? HAHALOLO or anonymous account?")
    public MobileElement questionTxtElem;

    @AndroidFindBy(id = "")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Log in with Hahalolo\"`]")
    public MobileElement loginHHLLBtnElem;

    @AndroidFindBy(id = "")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Log in Anonymously\"`]")
    public MobileElement loginAnonymouslyBtnElem;

    public String getHiTxtStr() {
        return hiTxtElem.getText().trim();
    }

    public String getQuestionTxtStr() {
        return questionTxtElem.getText().trim();
    }

    public void clickOnLoginHHLLBtn() {
        loginHHLLBtnElem.click();
    }

    public void clickOnLoginAnonymouslyBtn() {
        loginAnonymouslyBtnElem.click();
    }
}
