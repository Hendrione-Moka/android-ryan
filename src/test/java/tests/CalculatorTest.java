package tests;

import drivers.AndroidDriverInit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.CalculatorPage;
import pages.LoginPage;
import pages.NavBar;

public class CalculatorTest {

  private final LoginPage loginPage = new LoginPage();
  private final CalculatorPage calculatorPage = new CalculatorPage();
  private final NavBar navBar = new NavBar();

  @BeforeEach
  public void beforeScenario() {
    AndroidDriverInit.initialize();
    loginPage.inputUsername("admin");
    loginPage.inputPassword("admin");
    loginPage.clickButtonSignIn();
    Assertions.assertTrue(navBar.isNavBarAppear());
  }

  @AfterEach
  public void afterScenario() {
    TakesScreenshot screenshot = AndroidDriverInit.driver;
    byte[] imageByte = screenshot.getScreenshotAs(OutputType.BYTES);
    try {
      //java NIO
      Files.write(Paths.get("build/data.jpg"), imageByte);
    } catch (IOException e) {
      e.printStackTrace();
    }
    AndroidDriverInit.quit();
  }

  @Test
  public void verifyAddition() {
    calculatorPage.inputAngka1(10);
    calculatorPage.selectOperator("+");
    calculatorPage.inputAngka2(5);
    calculatorPage.clickButtonEqual();
    String actualLabelHasil = calculatorPage.getHasilLabel();
    Assertions.assertEquals("Hasil : 15", actualLabelHasil);
  }

  @Test
  public void verifySubstraction() {
    calculatorPage.inputAngka1(10);
    calculatorPage.selectOperator("-");
    calculatorPage.inputAngka2(5);
    calculatorPage.clickButtonEqual();
    String actualLabelHasil = calculatorPage.getHasilLabel();
    Assertions.assertEquals("Hasil : 5", actualLabelHasil);
  }

}
