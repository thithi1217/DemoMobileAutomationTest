package test_flows.login;

import context.SwitchContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.component.login.LoginWithHahaloloComponent;
import models.component.login.SSOLoginHahaloloComponent;
import models.pages.login.LoginWithHahaloloScreen;
import models.pages.login.WelcomeScreen;
import org.testng.asserts.SoftAssert;
import test_flows.BaseFlow;

public class LoginWithHahaloloFlow extends BaseFlow {

    private final AppiumDriver<MobileElement> appiumDriver;
    private String emailStr;
    private String passwordStr;
    private String displayNameStr;
    private boolean avatar;
    private SwitchContext switchContext;
    private String expectedContinueBtnLabel = "Continue";
    private String expectedTapHereLinkStr = "Not you? Tap here to change your account";

    public LoginWithHahaloloFlow(AppiumDriver<MobileElement> appiumDriver, String emailStr, String passwordStr, String displayNameStr, boolean avatar) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        this.emailStr = emailStr;
        this.passwordStr = passwordStr;
        this.displayNameStr = displayNameStr;
        this.avatar = avatar;
        this.switchContext = new SwitchContext(appiumDriver);
    }

    @Step("Login")
    public void login() {
        switchContext.switchToWebViewContext();

        WelcomeScreen welcomeScreen = new WelcomeScreen(appiumDriver);
        SSOLoginHahaloloComponent ssoLoginHahaloloComponent = welcomeScreen.ssoLoginHahaloloComponent();
        if (!emailStr.isEmpty()) {
            ssoLoginHahaloloComponent.emailTxtElem().clear();
            ssoLoginHahaloloComponent.inputEmailTxt(emailStr);
        }

        if (!passwordStr.isEmpty()) {
            ssoLoginHahaloloComponent.passwordTxtElem().clear();
            ssoLoginHahaloloComponent.inputPasswordTxt(passwordStr);
        }

        ssoLoginHahaloloComponent.clickOnLoginBtn();
    }

    @Step("Verify Login")
    public void verifyLogin() {
        WelcomeScreen welcomeScreen = new WelcomeScreen(appiumDriver);
        SSOLoginHahaloloComponent ssoLoginHahaloloComponent = welcomeScreen.ssoLoginHahaloloComponent();

        try {
            ssoLoginHahaloloComponent.errorTxtElem().isDisplayed();
            switchContext.switchToNativeContext();
            ssoLoginHahaloloComponent.clickOnCloseBtn();
        } catch (Exception ignored) {
            switchContext.switchToNativeContext();
            verifyUI();
        }
    }

    @Step("Verify UI")
    private void verifyUI() {
        LoginWithHahaloloScreen loginWithHahaloloScreen = new LoginWithHahaloloScreen(appiumDriver);
        LoginWithHahaloloComponent loginWithHahaloloComponent = loginWithHahaloloScreen.loginWithHahaloloComponent();

        verifyLogoHalome(loginWithHahaloloComponent);
        verifyAvatarUser(loginWithHahaloloComponent);
        verifyUsername(loginWithHahaloloComponent);
        verifyContinueBtn(loginWithHahaloloComponent);
        verifyTapHereLink(loginWithHahaloloComponent);

        // Back to welcome screen
        loginWithHahaloloComponent.clickOnBackBtn();
        WelcomeScreen welcomeScreen = new WelcomeScreen(appiumDriver);
        welcomeScreen.ssoLoginHahaloloComponent().clickOnCloseBtn();
    }

    @Step("Check Logo Halome is existed")
    private void verifyLogoHalome(LoginWithHahaloloComponent loginWithHahaloloComponent) {
        boolean isLogoHalomeDisplayed = loginWithHahaloloComponent.logoHalomeElem.isDisplayed();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isLogoHalomeDisplayed, "[ERR] Logo Halome is not display!");
        softAssert.assertAll();
    }

    @Step("Check Avatar user is existed")
    private void verifyAvatarUser(LoginWithHahaloloComponent loginWithHahaloloComponent) {
        boolean isAvatarUserDisplayed;

        if (avatar) {
            isAvatarUserDisplayed = loginWithHahaloloComponent.avatarUserElem.isDisplayed();
        } else {
            isAvatarUserDisplayed = loginWithHahaloloComponent.notAvatarUserElem.isDisplayed();
        }

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isAvatarUserDisplayed, "[ERR] Avatar User is incorrect!");
        softAssert.assertAll();
    }

    @Step("Check Username text is is displayed correctly")
    private void verifyUsername(LoginWithHahaloloComponent loginWithHahaloloComponent) {
        String actualUsernameStr = loginWithHahaloloComponent.usernameElem.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualUsernameStr, displayNameStr, "[ERR] Username str is incorrect");
        softAssert.assertAll();
    }

    @Step("Check Continue button is existed")
    private void verifyContinueBtn(LoginWithHahaloloComponent loginWithHahaloloComponent) {
        boolean isContinueBtnEnable = loginWithHahaloloComponent.continueBtnElem.isEnabled();
        String actualContinueBtnLabel = loginWithHahaloloComponent.continueBtnElem.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isContinueBtnEnable, "[ERR] Continue button is not enable");
        softAssert.assertEquals(actualContinueBtnLabel, expectedContinueBtnLabel, "[ERR] Continue button is incorrect name");
        softAssert.assertAll();
    }

    @Step("Check Tap here link is existed")
    private void verifyTapHereLink(LoginWithHahaloloComponent loginWithHahaloloComponent) {
        boolean isTapHereLinkEnable = loginWithHahaloloComponent.tapHereLinkElem.isEnabled();
        String actualTapHereLinkStr = loginWithHahaloloComponent.tapHereLinkElem.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isTapHereLinkEnable, "[ERR] Tap here link is not enable");
        softAssert.assertEquals(actualTapHereLinkStr, expectedTapHereLinkStr, "[ERR] Tap here link is incorrect name");
        softAssert.assertAll();
    }
}
