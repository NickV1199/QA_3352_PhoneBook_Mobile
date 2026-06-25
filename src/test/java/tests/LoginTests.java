package tests;

import config.AppiumConfig;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthentificationScreen;
import screens.ContactListScreen;

public class LoginTests extends AppiumConfig {



    @Test
    public void loginSuccess() {
//       boolean result = new SplashScreen(driver)
//                .checkCurrentVersion("Version 1.0.0")

        boolean result = new AuthentificationScreen(driver)
                .fillEmail("flower@gmail.com")
                .fillPassword("Flower123!")
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");

        Assert.assertTrue(result);
    }


    @Test
    public void loginSuccessModel() {
//        boolean result = new SplashScreen(driver)
//                .checkCurrentVersion("Version 1.0.0")
        boolean result = new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(User.builder()
                        .email("margo@gmail.com")
                        .password("Mmar123456$").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }


    @Test
    public void loginSuccessModel1() {
        Assert.assertTrue(new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(User.builder()
                        .email("margo@gmail.com")
                        .password("Mmar123456$").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list"));

    }


    @Test
    public void loginWrongEmail() {
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(User.builder()
                        .email("margogmail.com")
                        .password("Mmar123456$").build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");
    }

    @Test
    public void loginWrongPassword() {
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(User.builder()
                        .email("margo@gmail.com")
                        .password("Mmar123").build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");
    }

    @Test
    public void loginUnregistered() {
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(User.builder()
                        .email("margo123@gmail.com")
                        .password("Mmar123654$").build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");
    }





    @AfterMethod
    public void postCondition() {
        new ContactListScreen(driver).logout();
    }

}
