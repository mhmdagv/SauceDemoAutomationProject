package sauceDemo.elements;

import org.openqa.selenium.By;

public class LoginPOM {
    public static final By usernameInput = By.id("user-name");
    public static final By passwordInput = By.id("password");
    public static final By loginBtn = By.id("login-button");
    public static final By homepageHeader = By.className("app_logo");
    public static final By loginInputError = By.cssSelector(".error-message-container.error");
    public static final By logoutBtn = By.id("logout_sidebar_link");

}
