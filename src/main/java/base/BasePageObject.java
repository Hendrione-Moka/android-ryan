package base;

import drivers.AndroidDriverInit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasePageObject {

  public AndroidDriver<AndroidElement> getDriver(){
    return AndroidDriverInit.driver;
  }

}
