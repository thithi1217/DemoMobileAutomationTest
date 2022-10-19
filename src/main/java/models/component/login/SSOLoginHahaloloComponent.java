package models.component.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SSOLoginHahaloloComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    public SSOLoginHahaloloComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(15)), this);
    }

    private By hahaloloTitleSel = By.xpath("//span[contains(text(), 'Hahalolo')]");
    private By accountIdTxtSel = By.id("accountId");
    private By passwordTxtSel = By.id("password");
    private By loginBtnSel = By.cssSelector("button[type='submit']");

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/back_btn")
    @iOSXCUITFindBy(accessibility = "close_dark")
    public MobileElement closeBtnElem;

    public WebElement hahaloloTitleElem() {
        return appiumDriver.findElement(hahaloloTitleSel);
    }

    public WebElement accountIdTxtElem() {
        return appiumDriver.findElement(accountIdTxtSel);
    }

    public WebElement passwordTxtElem() {
        return appiumDriver.findElement(passwordTxtSel);
    }

    public WebElement loginBtnElem() {
        return appiumDriver.findElement(loginBtnSel);
    }

    @Step("Click on Close button")
    public void clickOnCloseBtn() {
        closeBtnElem.click();
    }

    @Step("Get Hahalolo title")
    public String getHahaloloTitleStr() {
        return hahaloloTitleElem().getText().trim();
    }

    @Step("Input account {accountStr}")
    public void inputAccountIdTxt(String accountStr) {
        accountIdTxtElem().sendKeys(accountStr);
    }

    @Step("Input account {passwordStr}")
    public void inputPasswordTxt(String passwordStr) {
        passwordTxtElem().sendKeys(passwordStr);
    }

    @Step("Click on Login button")
    public void clickOnLoginBtn() {
        loginBtnElem().click();
    }
}
