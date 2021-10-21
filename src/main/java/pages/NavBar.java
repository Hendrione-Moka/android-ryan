package pages;

import base.BasePageObject;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBar extends BasePageObject {

  public boolean isNavBarAppear(){
    WebDriverWait wait = new WebDriverWait(getDriver(),30, 1000);
    By hamburgerButtonLocator = MobileBy.AccessibilityId("Open navigation drawer");
    AndroidElement buttonHamburger = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(hamburgerButtonLocator));
    return buttonHamburger.isDisplayed();
  }

}
