package pages;

import base.BasePageObject;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class CalculatorPage extends BasePageObject {

  public void inputAngka1(Integer number){
    By inputAngka1Locator = MobileBy.id("et_1");
    AndroidElement inputAngka1 = getDriver().findElement(inputAngka1Locator);
    inputAngka1.sendKeys(number.toString());
  }

  public void inputAngka2(Integer number){
    By inputAngka2Locator = MobileBy.id("et_2");
    AndroidElement inputAngka2 = getDriver().findElement(inputAngka2Locator);
    inputAngka2.sendKeys(number.toString());
  }

  public void clickButtonEqual(){
    By buttonEqualLocator = MobileBy.id("acb_calculate");
    AndroidElement buttonEqual = getDriver().findElement(buttonEqualLocator);
    buttonEqual.click();
  }

  public void selectOperator(String sign){
    By dropdownLocator = MobileBy.id("spinner_1");
    AndroidElement dropdown = getDriver().findElement(dropdownLocator);
    dropdown.click();
    By dropdownListLocator = MobileBy.xpath(String.format("//android.widget.TextView[@text='%s']", sign));
    AndroidElement dropDownList = getDriver().findElement(dropdownListLocator);
    dropDownList.click();
  }

  //Hasil : 0
  public String getHasilLabel(){
    By labelHasilLocator = MobileBy.id("tv_result");
    AndroidElement labelHasil = getDriver().findElement(labelHasilLocator);
    return labelHasil.getText();
  }

}
