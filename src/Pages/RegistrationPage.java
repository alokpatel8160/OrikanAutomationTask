package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationPage {

    WebDriver driver;

    By EmailAdd = By.id("emailAddress");
    By EmailValidationMessage = By.xpath("//div[@class='validation error']");

    By Password = By.id("password");
    By PasswordValidationMessage = By.xpath("//div[@class='validation error']");

    By ConfirmPassword = By.id("confirmPassword");
    By ConfirmPasswordValidationMessage = By.xpath("//div[@class='validation error']");

    By NextOnRegistration = By.xpath("//button[contains(.,'Next')]");

    public void EnterEmailAddress(String email)
    {
        this.driver.findElement(this.EmailAdd).clear();
        this.driver.findElement(this.EmailAdd).click();
        this.driver.findElement(this.EmailAdd).sendKeys(email);

    }

    public String GetEmailValidation()
    {
        String EmailFieldValidation = driver.findElement(EmailValidationMessage).getText();

        return EmailFieldValidation;
    }



    public void EnterPassword(String email)
    {
        this.driver.findElement(this.Password).clear();
        this.driver.findElement(this.Password).click();
        this.driver.findElement(this.Password).sendKeys(email);

    }

    public String GetPasswordValidation()
    {
        String PasswordFieldValidation = driver.findElement(PasswordValidationMessage).getText();

        return PasswordFieldValidation;
    }

    public void EnterConfirmPassword(String email)
    {
        this.driver.findElement(this.ConfirmPassword).clear();
        this.driver.findElement(this.ConfirmPassword).click();
        this.driver.findElement(this.ConfirmPassword).sendKeys(email);

    }

    public String GetConfirmPasswordValidation()
    {
        String ConfirmPasswordFieldValidation = driver.findElement(PasswordValidationMessage).getText();

        return ConfirmPasswordFieldValidation;
    }

    public void ClickOnNextFromRegistration()
    {
        this.driver.findElement(this.NextOnRegistration).click();

    }
    public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
    }
}

