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
        welcomeFlow.goToSSOLoginHHLLScreen();
        welcomeFlow.verifyNavToLoginHHLL();
    }

    @Test (description = "Verify click on Login Anonymously button on Welcome screen")
    public void testLoginAnonymouslyBtn() throws InterruptedException {
        WelcomeFlow welcomeFlow = new WelcomeFlow(getDriver());
        welcomeFlow.goToLoginAnonymouslyScreen();
        welcomeFlow.verifyNavToLoginAnonymously();
    }

    @Test (description = "Verify Language modal on Welcome screen")
    public void testLanguageModal() {
        WelcomeFlow welcomeFlow = new WelcomeFlow(getDriver());
        welcomeFlow.goToLanguageModal();
        welcomeFlow.verifyNavToLanguageModal();
//        welcomeFlow.verifyLanguageBtn();
    }
}
