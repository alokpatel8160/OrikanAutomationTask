package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class TNCPage {
    WebDriver driver;

    By TNCPage = By.id("termsAndConditions");
    By TNCPage1 = By.cssSelector("#termsAndConditions");
    By AgreeTerms = By.id("agreedToTerms");
    By BackOnTNC = By.xpath("//button[contains(.,'Back')]");
    By Submit = By.xpath("//button[contains(.,'Submit')]");

    By ValidationMessage = By.xpath("//div[@class='validation error']//span");


    public void ScrollOnTNCRead()
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement W1 = this.driver.findElement(this.TNCPage1);
        W1.click();
        js.executeScript("document.querySelector('#termsAndConditions').scrollTop=4000");
    }

    public void SelectAgreeTermsAndCondition()
    {
        this.driver.findElement(this.AgreeTerms).click();
    }

    public void IsRedirectOnTNCPage() throws Exception {

        Boolean ContactPage = this.driver.findElement(this.TNCPage).isDisplayed();

        if (ContactPage == true) {
            return;
        }
        else
        {
            throw new Exception("There is an error in Payment Page");
        }
    }

    public void ClickOnSubmit()
    {
        this.driver.findElement(this.Submit).click();
    }

    public void ClickOnBackFromTNC()
    {
        this.driver.findElement(this.BackOnTNC).click();

    }

    public String GetValidationMessage()
    {
        String FieldValidation = driver.findElement(ValidationMessage).getText();

        return FieldValidation;
    }

    public TNCPage(WebDriver driver) {
        this.driver = driver;
    }

}
