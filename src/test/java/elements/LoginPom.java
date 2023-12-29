package elements;

import lombok.Data;
import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Data
public final class LoginPom {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By homepageHeader = By.className("app_logo");
    private final By loginInputError = By.cssSelector(".error-message-container.error");
    private final By logoutBtn = By.id("logout_sidebar_link");

    private LoginPom(){

    }

    private static LoginPom INSTANCE; // 1

    public static LoginPom getInstance(){
        if(INSTANCE == null) {
            INSTANCE = new LoginPom();
        }
        return INSTANCE;
    }
}
