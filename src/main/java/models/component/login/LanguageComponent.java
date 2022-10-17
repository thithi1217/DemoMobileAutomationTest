package models.component.login;

import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LanguageComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    public LanguageComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(xpath = "//*[@text=\"Language\"]")
    @iOSXCUITFindBy(accessibility = "Select a language")
    public MobileElement titleTxtElem;

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/language_name_tv")
    @iOSXCUITFindBy(iOSClassChain = "**XCUIElementTypeCell/XCUIElementTypeStaticText")
    public List<MobileElement> languageTableElem;

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/done_bt")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ok\"`]")
    public MobileElement okBtnElem;

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/back_bt") // Back button
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Cancel\"`]") // Cancel button
    public MobileElement cancelBtnElem;

    @Step("Get title text")
    public String getTitleTxtStr() {
        return titleTxtElem.getText().trim();
    }

    @Step("Get all list country")
    public List<String> getListCountry() {
        List<String> listCountry = new ArrayList<>();
        if (Platforms.valueOf(appiumDriver.getPlatformName()) == Platforms.ios) {
            for (MobileElement countryElem : languageTableElem) {
                listCountry.add(countryElem.getAttribute("label"));
            }
        } else {
            for (MobileElement countryElem : languageTableElem) {
                listCountry.add(countryElem.getAttribute("text"));
            }
        }
        return listCountry;
    }

    @Step("Select random country {country}")
    public void selectRandomCountry (String country) {
        System.out.println(country);
        // Click 1 to scroll, click 2 to check radio
        for (int i = 0; i < 2; i++) {
            By countryElem = MobileBy.AccessibilityId(country);
            appiumDriver.findElement(countryElem).click();
        }
    }

    @Step("Click on Ok button")
    public void clickOnOklBtn() {
        okBtnElem.click();
    }

    @Step("Click on Cancel button")
    public void clickOnCancelBtn() {
        cancelBtnElem.click();
    }
}
