package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import java.util.List;

public class ContactPage {
    WebDriver driver;

    By ContactPage = By.id("firstName");
    By FirstName = By.id("firstName");
    By MiddleName = By.id("middleName");
    By LastName = By.id("lastName");
    By PreferredFullName = By.id("preferredFullName");
    By AddressLine1 = By.id("addressLine1");
    By AddressLine2 = By.id("addressLine2");
    By AddressLine3 = By.id("addressLine3");
    By PostalCode = By.id("postcode");
    By City = By.id("city");
    By State = By.id("state");

    By ValidationMessage = By.xpath("//div[@class='validation error']//span");

    By BackOnContact = By.xpath("//button[contains(.,'Back')]");
    By NextOnContact = By.xpath("//button[contains(.,'Next')]");

    public void IsRedirectOnContactPage() throws Exception {

        List<WebElement> elements = driver.findElements(ContactPage);

        if(elements.size() > 0)
        {
            return;
        }
        else
        {
            throw new Exception("There is an error in Registration Page");
        }
    }

    public void EnterFirstName(String FirstName)
    {
        this.driver.findElement(this.FirstName).clear();
        this.driver.findElement(this.FirstName).click();
        this.driver.findElement(this.FirstName).sendKeys(FirstName);
    }

    public void EnterMiddleName(String MiddleName)
    {
        this.driver.findElement(this.MiddleName).clear();
        this.driver.findElement(this.MiddleName).click();
        this.driver.findElement(this.MiddleName).sendKeys(MiddleName);
    }

    public void EnterLastName(String LastName)
    {
        this.driver.findElement(this.LastName).clear();
        this.driver.findElement(this.LastName).click();
        this.driver.findElement(this.LastName).sendKeys(LastName);
    }

    public void GetPreferredFullName()
    {
        this.driver.findElement(this.PreferredFullName).getText();
    }

    public void EnterPreferredFullName(String FullName)
    {
        this.driver.findElement(this.PreferredFullName).clear();
        this.driver.findElement(this.PreferredFullName).click();
        this.driver.findElement(this.PreferredFullName).sendKeys(FullName);
    }

    public void EnterAddressLine1(String AddressLine1)
    {
        this.driver.findElement(this.AddressLine1).clear();
        this.driver.findElement(this.AddressLine1).click();
        this.driver.findElement(this.AddressLine1).sendKeys(AddressLine1);
    }

    public void EnterAddressLine2(String AddressLine2)
    {
        this.driver.findElement(this.AddressLine2).clear();
        this.driver.findElement(this.AddressLine2).click();
        this.driver.findElement(this.AddressLine2).sendKeys(AddressLine2);
    }

    public void EnterAddressLine3(String AddressLine3)
    {
        this.driver.findElement(this.AddressLine3).clear();
        this.driver.findElement(this.AddressLine3).click();
        this.driver.findElement(this.AddressLine3).sendKeys(AddressLine3);
    }

    public void EnterPostalCode(String PostalCode)
    {
        this.driver.findElement(this.PostalCode).clear();
        this.driver.findElement(this.PostalCode).click();
        this.driver.findElement(this.PostalCode).sendKeys(PostalCode);
    }

    public void EnterCity(String City)
    {
        this.driver.findElement(this.City).clear();
        this.driver.findElement(this.City).click();
        this.driver.findElement(this.City).sendKeys(City);
    }

    public void SelectState(String State)
    {
        Select state = new Select(this.driver.findElement(this.State));
        state.selectByVisibleText(State);
    }

    public String GetValidationMessage()
    {
        String FieldValidation = driver.findElement(ValidationMessage).getText();

        return FieldValidation;
    }

    public void ClickOnNextFromContact()
    {
        this.driver.findElement(this.NextOnContact).click();
    }

    public void ClickOnBackFromContact()
    {
        this.driver.findElement(this.BackOnContact).click();

    }
    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

}
