package test.login;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.login.WelcomeFlow;

public class WelcomeScreenTest extends BaseTest {

    @Test (description = "Verify UI on Welcome screen")
    @Description("Verify UI on Welcome screen")
    public void testUI() {
        WelcomeFlow welcomeFlow = new WelcomeFlow(getDriver());
        welcomeFlow.verifyUI();
    }

}
