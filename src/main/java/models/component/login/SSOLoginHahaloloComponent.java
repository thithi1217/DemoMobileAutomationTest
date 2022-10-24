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
    private By emailTxtSel = By.id("accountId");
    private By passwordTxtSel = By.id("password");
    private By errorTxtSel = By.xpath("//span[contains(text(), 'Tên tài khoản hoặc mật khẩu không chính xác')]");
    private By loginBtnSel = By.cssSelector("button[type='submit']");

    @AndroidFindBy(id = "com.hahalolo.android.halome:id/back_btn")
    @iOSXCUITFindBy(accessibility = "close_dark")
    public MobileElement closeBtnElem;

    public WebElement hahaloloTitleElem() {
        return appiumDriver.findElement(hahaloloTitleSel);
    }

    public WebElement emailTxtElem() {
        return appiumDriver.findElement(emailTxtSel);
    }

    public WebElement passwordTxtElem() {
        return appiumDriver.findElement(passwordTxtSel);
    }

    public WebElement errorTxtElem() {
        return appiumDriver.findElement(errorTxtSel);
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

    @Step("Input account: {emailStr}")
    public void inputEmailTxt(String emailStr) {
        emailTxtElem().sendKeys(emailStr);
    }

    @Step("Input password: {passwordStr}")
    public void inputPasswordTxt(String passwordStr) {
        passwordTxtElem().sendKeys(passwordStr);
    }

    @Step("Get error text")
    public String getErrorTxtStr() {
        return errorTxtElem().getText().trim();
    }

    @Step("Click on Login button at web sso screen")
    public void clickOnLoginBtn() {
        loginBtnElem().click();
    }
}
