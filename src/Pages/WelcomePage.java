package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class WelcomePage {
    WebDriver driver;

    By ConfirmationPage = By.cssSelector("app-register-complete-page");


    public String GetConfirmationMessage()
    {
        String ConfirmationMessage = driver.findElement(ConfirmationPage).getText();

        return ConfirmationMessage;
    }

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }

}
