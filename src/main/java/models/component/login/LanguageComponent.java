package models.component.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LanguageComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    public LanguageComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(id = "")
    @iOSXCUITFindBy(accessibility = "Select a language")
    public MobileElement titleTxtElem;

    @AndroidFindBy(id = "")
    @iOSXCUITFindBy(iOSClassChain = "**XCUIElementTypeCell/XCUIElementTypeStaticText")
    public List<MobileElement> languageTableElem;

    @AndroidFindBy(id = "")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ok\"`]")
    public MobileElement okBtnElem;

    @AndroidFindBy(id = "")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Cancel\"`]")
    public MobileElement cancelBtnElem;

    @Step("Get all list country")
    public List<String> getListCountry() {
        List<String> listCountry = new ArrayList<>();
        for (MobileElement countryElem : languageTableElem) {
            listCountry.add(countryElem.getAttribute("label"));
        }
        return listCountry;
    }
    @Step("Click on Cancel button")
    public void clickOnCancelBtn() {
        cancelBtnElem.click();
    }
}
