package test.login;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.DataObjectBuilder;
import test_data.models.LoginHahaloloData;
import test_flows.login.LoginWithHahaloloFlow;

public class LoginWithHahaloloScreenTest extends BaseTest {

    @Test(dataProvider = "loginHahaloloData", description = "Verify UI on Login with Hahalolo screen")
    public void testUI(LoginHahaloloData loginHahaloloData) {
        String email = loginHahaloloData.getEmail();
        String password = loginHahaloloData.getPassword();
        String displayName = loginHahaloloData.getDisplayName();
        boolean avatar = loginHahaloloData.isAvatar();

        LoginWithHahaloloFlow loginWithHahaloloFlow = new LoginWithHahaloloFlow(getDriver(), email, password, displayName, avatar);
        loginWithHahaloloFlow.goToSSOLoginHHLLScreen();
        loginWithHahaloloFlow.login();
        loginWithHahaloloFlow.verifyLogin();
    }

    @DataProvider
    public LoginHahaloloData[] loginHahaloloData() {
        String filePath = "/src/main/java/test_data/login/LoginWithHahalolo.json";
        return DataObjectBuilder.buildDataObject(filePath, LoginHahaloloData[].class);
    }
}
