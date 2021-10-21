package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import properties.AppiumProperties;
import properties.PropertiesData;
import properties.PropertiesReader;

public class AndroidDriverInit {

  public static AndroidDriver<AndroidElement> driver;

  public static void initialize(){
    PropertiesReader props = new PropertiesReader();
    AppiumProperties properties = props.readProperties().getAppiumProperties();
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
    caps.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getDeviceName());
    caps.setCapability(MobileCapabilityType.UDID, properties.getUdid());
    caps.setCapability(MobileCapabilityType.APP, properties.getApp());
    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
    caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, properties.getNewCommandTimeout());
    try {
      driver = new AndroidDriver<AndroidElement>(new URL(properties.getAppiumUrl()), caps);
      //implicit wait
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

  }

  public static void quit(){
    driver.quit();
  }

}
