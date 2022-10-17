package models.component.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
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

    private By hahaloloTitleSel = By.cssSelector("[text='Hahalolo']");
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

    public void clickOnCloseBtn() {
        closeBtnElem.click();
    }

    public String getHahaloloTitleStr() {
        return hahaloloTitleElem().getText().trim();
    }

    public void inputAccountIdTxt(String accountStr) {
        accountIdTxtElem().sendKeys(accountStr);
    }

    public void inputPasswordTxt(String passwordStr) {
        passwordTxtElem().sendKeys(passwordStr);
    }

    public void clickOnLoginBtn() {
        loginBtnElem().click();
    }
}
