package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AuthentificationScreen extends BaseScreen{
    public AuthentificationScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.sheygam.contactapp:id/inputEmail")
    WebElement emailEditText;

    @AndroidFindBy(id = "com.sheygam.contactapp:id/inputPassword")
    WebElement passwordEditText;

    @AndroidFindBy(id = "com.sheygam.contactapp:id/loginBtn")
    WebElement loginBtn;

    @AndroidFindBy(id = "com.sheygam.contactapp:id/regBtn" )
    WebElement regBtn;

    public AuthentificationScreen fillEmail(String email){
        should(emailEditText, 10);
        type(emailEditText, email);
        return this;
    }

    public AuthentificationScreen fillPassword(String password){
        type(passwordEditText, password);
        return this;
    }

    public ContactListScreen submitLogin(){
        loginBtn.click();
        return new ContactListScreen(driver);
    }

    public AuthentificationScreen submitLoginNegative(){
        loginBtn.click();
        return this;
    }


    public AuthentificationScreen fillLoginRegistrationForm(User user) {
        should(emailEditText,10);
        type(emailEditText,user.getEmail());
        type(passwordEditText, user.getPassword());
        return this;
    }


    public AuthentificationScreen isErrorMessageHasText(String text) {
        checkAlertText(text);
        return this;
    }

    public ContactListScreen submitRegistration() {
        regBtn.click();
        return new ContactListScreen(driver);
    }

}
