package tests;

import config.AppiumConfig;
import models.User;
import org.testng.annotations.Test;
import screens.AuthentificationScreen;

public class LoginTests_Second extends AppiumConfig {


    @Test
    public void loginSuccess(){
        new AuthentificationScreen(driver)
                .fillEmail("flower@gmail.com")
                .fillPassword("Flower123!")
                .submitLogin()
                .isAccountOpened()
                .logout();

    }


    @Test
    public void loginSuccessModel(){
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(User.builder()
                        .email("flower@gmail.com")
                        .password("Flower123!").build())
                .submitLogin()
                .isAccountOpened()
                .logout();

    }


}
