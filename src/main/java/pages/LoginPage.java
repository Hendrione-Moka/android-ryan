package pages;

import base.BasePageObject;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class LoginPage extends BasePageObject {

  public void inputUsername(String username){
    By inputUsernameLocator = MobileBy.id("username");
    AndroidElement inputUsername = getDriver().findElement(inputUsernameLocator);
    inputUsername.sendKeys(username);
  }

  public void inputPassword(String password){
    By inputPasswordLocator = MobileBy.id("password");
    AndroidElement inputPassword = getDriver().findElement(inputPasswordLocator);
    inputPassword.sendKeys(password);
  }

  public void clickButtonSignIn(){
    By inputButtonSignInLocator = MobileBy.id("login");
    AndroidElement buttonSignIn = getDriver().findElement(inputButtonSignInLocator);
    buttonSignIn.click();
  }


}
