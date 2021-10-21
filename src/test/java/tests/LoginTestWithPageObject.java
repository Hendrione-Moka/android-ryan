package tests;

import drivers.AndroidDriverInit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.NavBar;

public class LoginTestWithPageObject {

  private LoginPage loginPage = new LoginPage();
  private NavBar navBar = new NavBar();

  @Test
  public void loginWithValidData() {
    AndroidDriverInit.initialize();
    loginPage.inputUsername("admin");
    loginPage.inputPassword("admin");
    loginPage.clickButtonSignIn();
    Assertions.assertTrue(navBar.isNavBarAppear());
    AndroidDriverInit.quit();
  }

}
