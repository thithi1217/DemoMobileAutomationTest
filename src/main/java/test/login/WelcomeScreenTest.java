package test.login;

import io.qameta.allure.Description;
import models.component.login.WelcomeComponent;
import models.pages.login.WelcomeScreen;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.login.WelcomeFlow;

public class WelcomeScreenTest extends BaseTest {

    @Test (description = "Verify UI on Welcome screen")
//    @Description("Verify UI on Welcome screen")
    public void testUI() {
        WelcomeFlow welcomeFlow = new WelcomeFlow(getDriver());
        welcomeFlow.verifyUI();
    }

    @Test (description = "Verify Language modal on Welcome screen")
//    @Description("Verify UI on Welcome screen")
    public void testLanguage() {
        WelcomeFlow welcomeFlow = new WelcomeFlow(getDriver());
        welcomeFlow.goToLanguageModal();
        welcomeFlow.verifyLanguageBtn();
    }
}
