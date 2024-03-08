package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PaymentPage {
    WebDriver driver;

    By PaymentPage = By.id("cardHolderName");
    By CardHolderName = By.id("cardHolderName");
    By CardTypeVisa = By.id("cardTypeVISA");
    By CardTypeMaster = By.id("cardTypeMastercard");
    By CardNumber = By.id("cardNumber");
    By CardCVV = By.id("cardCVV");
    By CardExpMonth = By.id("cardExpiryMonth");
    By CardExpYear = By.id("cardExpiryYear");

    By BackOnPayment = By.xpath("//button[contains(.,'Back')]");
    By NextOnPayment = By.xpath("//button[contains(.,'Next')]");

    By ValidationMessage = By.xpath("//div[@class='validation error']//span");

    public void EnterCardHolderName(String CardHolderName)
    {
        this.driver.findElement(this.CardHolderName).clear();
        this.driver.findElement(this.CardHolderName).click();
        this.driver.findElement(this.CardHolderName).sendKeys(CardHolderName);
    }

    public void SelectCardTypeVisa()
    {
        this.driver.findElement(this.CardTypeVisa).click();
    }

    public void SelectCardTypeMaster()
    {
        this.driver.findElement(this.CardTypeMaster).click();
    }

    public void EnterCardNumber(String CardNumber)
    {
        this.driver.findElement(this.CardNumber).clear();
        this.driver.findElement(this.CardNumber).click();
        this.driver.findElement(this.CardNumber).sendKeys(CardNumber);
    }


    public void EnterCardCVV(String CardCVV)
    {
        this.driver.findElement(this.CardCVV).clear();
        this.driver.findElement(this.CardCVV).click();
        this.driver.findElement(this.CardCVV).sendKeys(CardCVV);
    }

    public void SelectCardExpMonth(String CardExpMonth)
    {
        Select state = new Select(this.driver.findElement(this.CardExpMonth));
        state.selectByVisibleText(CardExpMonth);
    }


    public void EnterCardExpYear(String CardExpYear)
    {
        this.driver.findElement(this.CardExpYear).clear();
        this.driver.findElement(this.CardExpYear).click();
        this.driver.findElement(this.CardExpYear).sendKeys(CardExpYear);
    }

    public void ClickOnNextFromPayment()
    {
        this.driver.findElement(this.NextOnPayment).click();
    }

    public void ClickOnBackFromPayment()
    {
        this.driver.findElement(this.BackOnPayment).click();

    }


    public String GetValidationMessage()
    {
        String FieldValidation = driver.findElement(ValidationMessage).getText();

        return FieldValidation;
    }

    public void IsRedirectOnPaymentPage() throws Exception {

        Boolean ContactPage = this.driver.findElement(this.PaymentPage).isDisplayed();

        if (ContactPage == true) {
            return;
        }
        else
        {
            throw new Exception("There is an error in Registration Page");
        }
    }

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

}
