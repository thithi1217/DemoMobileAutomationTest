package test.login;

import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.login.WelcomeFlow;

public class WelcomeScreenTest extends BaseTest {

    @Test (description = "Verify UI on Welcome screen")
    public void testUI() {
        WelcomeFlow welcomeFlow = new WelcomeFlow(getDriver());
        welcomeFlow.verifyUI();
    }

    @Test (description = "Verify click on Login with Hahalolo button on Welcome screen")
    public void testLoginHHLLBtn() {
        WelcomeFlow welcomeFlow = new WelcomeFlow(getDriver());
        welcomeFlow.goToLoginHHLLScreen();
        welcomeFlow.verifyNavToLoginHHLL();
    }

    @Test (description = "Verify Language modal on Welcome screen")
    public void testLanguageModal() {
        WelcomeFlow welcomeFlow = new WelcomeFlow(getDriver());
        welcomeFlow.goToLanguageModal();
        welcomeFlow.verifyNavToLanguageModal();
//        welcomeFlow.verifyLanguageBtn();
    }
}
