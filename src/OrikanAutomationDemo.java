import Pages.*;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class OrikanAutomationDemo
{
    WebDriver driver;

    @BeforeTest
    public void ProcessURL()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/alokpatel/Documents/chromedriver/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://orikan-ui-automation-test.azurewebsites.net/");
        driver.manage().window().maximize();
    }

    @Test
    public void BlankEmailValidation() throws Exception {

        RegistrationPage Register = new RegistrationPage(driver);
        Register.ClickOnNextFromRegistration();
        String BlankEmailValidation = Register.GetEmailValidation();
        assertEquals(BlankEmailValidation, "Email Address is required");

    }

    @Test
    public void BlankPasswordValidation() throws Exception {

        RegistrationPage Register = new RegistrationPage(driver);
        Register.EnterEmailAddress("test_person@gmail.com");
        Register.ClickOnNextFromRegistration();
        String BlankPasswordValidation = Register.GetPasswordValidation();
        assertEquals(BlankPasswordValidation, "Password is required.");

    }

    @Test
    public void BlankConfirmPasswordValidation() throws Exception {
        RegistrationPage Register = new RegistrationPage(driver);
        Register.EnterEmailAddress("test_person@gmail.com");
        Register.EnterPassword("test");
        Register.ClickOnNextFromRegistration();
        String BlankConfirmPasswordValidation = Register.GetConfirmPasswordValidation();
        assertEquals(BlankConfirmPasswordValidation, "Confirm Password is required");

    }

    @Test
    public void InvalidEmailAddressValidation() throws Exception
    {
        RegistrationPage Register = new RegistrationPage(driver);
        Register.EnterEmailAddress("test123");
        Register.ClickOnNextFromRegistration();
        String InvalidEmailValidation = Register.GetEmailValidation();
        System.out.println("InvalidEmailValidation :"+ InvalidEmailValidation);
        assertEquals(InvalidEmailValidation, "Invalid email address.");
    }

    @Test
    public void PasswordMismatchValidation() throws Exception
    {
        RegistrationPage Register = new RegistrationPage(driver);
        Register.EnterEmailAddress("test@gmail.com");
        Register.EnterPassword("Test@123");
        Register.EnterConfirmPassword("Test@12");
        Register.ClickOnNextFromRegistration();
        String PasswordDifferentValidation = Register.GetPasswordValidation();
        System.out.println("Pass and Confir pass diff valdiation :"+ PasswordDifferentValidation);
        assertEquals(PasswordDifferentValidation, "Passwords do not mach");
    }

    @Test
    public void ProcessWithSpaceInPasswordFields() throws Exception
    {
        RegistrationPage Register = new RegistrationPage(driver);
        ContactPage Contact = new ContactPage(driver);
        Register.EnterEmailAddress("test@gmail.com");
        Register.EnterPassword(" ");
        Register.EnterConfirmPassword(" ");
        Thread.sleep(2000);
        String SpaceInPasswordValidation = Register.GetPasswordValidation();
        System.out.println("SpaceInPasswordValidation :"+ SpaceInPasswordValidation);
        assertEquals(SpaceInPasswordValidation, "Do not allow to enter space in password field");
    }

    @Test
    public void CheckValidEmailWithNumbers() throws Exception
    {
        RegistrationPage Register = new RegistrationPage(driver);
        ContactPage Contact = new ContactPage(driver);
        Register.EnterEmailAddress("test123@gmail.com");
        Register.EnterPassword("Test@123");
        Register.EnterConfirmPassword("Test@123");
        Register.ClickOnNextFromRegistration();
        Thread.sleep(5000);
        Contact.IsRedirectOnContactPage();
    }

    @Test
    public void ValidEmailAndPassword() throws Exception
    {
        RegistrationPage Register = new RegistrationPage(driver);
        ContactPage Contact = new ContactPage(driver);
        Register.EnterEmailAddress("test@gmail.com");
        Register.EnterPassword("Test@123");
        Register.EnterConfirmPassword("Test@123");
        Register.ClickOnNextFromRegistration();
        Thread.sleep(5000);
        Contact.IsRedirectOnContactPage();

    }

    @Test
    public void BlankFirstNameValidation() throws Exception
    {
        ContactPage Contact = new ContactPage(driver);
        Contact.ClickOnNextFromContact();
        String BlankFirstNameValidation = Contact.GetValidationMessage();
        System.out.println("BlankFirstNameValidation :"+ BlankFirstNameValidation);
        assertEquals(BlankFirstNameValidation, "First Name is required");
    }

    @Test
    public void EnterSpaceInFirstName() throws Exception
    {
        ContactPage Contact = new ContactPage(driver);
        Contact.EnterFirstName(" ");
        Contact.ClickOnNextFromContact();
        String SpaceFirstNameValidation = Contact.GetValidationMessage();
        System.out.println("SpaceFirstNameValidation :"+ SpaceFirstNameValidation);
        assertEquals(SpaceFirstNameValidation, "It should not allow to enter Space in First Name");
    }

    @Test
    public void EnterInvalidValueInFirstName() throws Exception
    {
        ContactPage Contact = new ContactPage(driver);
        Contact.EnterFirstName("111");
        Contact.ClickOnNextFromContact();
        String NumbericValueFirstNameValidation = Contact.GetValidationMessage();
        System.out.println("NumbericValueFirstNameValidation :"+ NumbericValueFirstNameValidation);
        assertEquals(NumbericValueFirstNameValidation, "It should not allow to enter Number(0-9) and Special Character in First Name");
    }

    @Test
    public void BlankLastNameValidation() throws Exception
    {
        ContactPage Contact = new ContactPage(driver);
        Contact.EnterFirstName("John");
        Contact.ClickOnNextFromContact();
        String BlankLastNameValidation = Contact.GetValidationMessage();
        System.out.println("BlankLastNameValidation :"+ BlankLastNameValidation);
        assertEquals(BlankLastNameValidation, "Last Name is required");
    }

    @Test
    public void EnterSpaceInLastName() throws Exception
    {
        ContactPage Contact = new ContactPage(driver);
        Contact.EnterFirstName("John");
        Contact.EnterLastName(" ");
        Contact.ClickOnNextFromContact();
        String SpaceLastNameValidation = Contact.GetValidationMessage();
        System.out.println("SpaceLastNameValidation :"+ SpaceLastNameValidation);
        assertEquals(SpaceLastNameValidation, "It should not allow to enter Space in Last Name");
    }

    @Test
    public void EnterInvalidValueInLastName() throws Exception
    {
        ContactPage Contact = new ContactPage(driver);
        Contact.EnterFirstName("John");
        Contact.EnterLastName("$%^@&*@!@");
        Contact.ClickOnNextFromContact();
        String NumbericValueFirstNameValidation = Contact.GetValidationMessage();
        System.out.println("NumbericValueFirstNameValidation :"+ NumbericValueFirstNameValidation);
        assertEquals(NumbericValueFirstNameValidation, "It should not allow to enter Number(0-9) and Special Character in Last Name");
    }

    @Test
    public void BlankAddress1Validation() throws Exception
    {
        ContactPage Contact = new ContactPage(driver);
        Contact.EnterFirstName("John");
        Contact.EnterLastName("Wood");
        Contact.ClickOnNextFromContact();
        String BlankAddress1Validation = Contact.GetValidationMessage();
        System.out.println("BlankAddress1Validation :"+ BlankAddress1Validation);
        assertEquals(BlankAddress1Validation, "Address Line 1 is required");
    }

    @Test
    public void EnterSpaceInAddressLine1() throws Exception
    {
        ContactPage Contact = new ContactPage(driver);
        Contact.EnterFirstName("John");
        Contact.EnterLastName("Mark");
        Contact.EnterAddressLine1(" ");
        Contact.ClickOnNextFromContact();
        String SpaceAddressLine1Validation = Contact.GetValidationMessage();
        System.out.println("SpaceAddressLine1Validation :"+ SpaceAddressLine1Validation);
        assertEquals(SpaceAddressLine1Validation, "It should not allow to enter Space in Address Line 1");
    }

    @Test
    public void BlankPostalCodeValidation() throws Exception
    {
        ContactPage Contact = new ContactPage(driver);
        Contact.EnterFirstName("John");
        Contact.EnterLastName("Wood");
        Contact.EnterAddressLine1("45 Main Street");
        Contact.ClickOnNextFromContact();
        String BlankPostalCodeValidation = Contact.GetValidationMessage();
        System.out.println("BlankPostalCodeValidation :"+ BlankPostalCodeValidation);
        assertEquals(BlankPostalCodeValidation, "Postcode is required");
    }

    @Test
    public void EnterSpaceInPostalCode() throws Exception
    {
        ContactPage Contact = new ContactPage(driver);
        Contact.EnterFirstName("John");
        Contact.EnterLastName("Mark");
        Contact.EnterAddressLine1("Main Street");
        Contact.EnterPostalCode(" ");
        Contact.ClickOnNextFromContact();
        String SpacePostalCodeValidation = Contact.GetValidationMessage();
        System.out.println("SpacePostalCodeValidation :"+ SpacePostalCodeValidation);
        assertEquals(SpacePostalCodeValidation, "It should not allow to enter Space in Postal Code");
    }

    @Test
    public void BlankCityValidation() throws Exception
    {
        ContactPage Contact = new ContactPage(driver);
        Contact.EnterFirstName("John");
        Contact.EnterLastName("Wood");
        Contact.EnterAddressLine1("45 Main Street");
        Contact.EnterPostalCode("803123");
        Contact.ClickOnNextFromContact();
        String BlankCityValidation = Contact.GetValidationMessage();
        System.out.println("BlankCityValidation :"+ BlankCityValidation);
        assertEquals(BlankCityValidation, "City is required");
    }

    @Test
    public void EnterSpaceInCity() throws Exception
    {
        ContactPage Contact = new ContactPage(driver);
        Contact.EnterFirstName("John");
        Contact.EnterLastName("Mark");
        Contact.EnterAddressLine1("Main Street");
        Contact.EnterPostalCode("456122");
        Contact.EnterCity(" ");
        Contact.ClickOnNextFromContact();
        String SpaceCityValidation = Contact.GetValidationMessage();
        System.out.println("SpaceCityValidation :"+ SpaceCityValidation);
        assertEquals(SpaceCityValidation, "It should not allow to enter Space in City");
    }

    @Test
    public void BlankStateValidation() throws Exception
    {
        ContactPage Contact = new ContactPage(driver);
        Contact.EnterFirstName("John");
        Contact.EnterLastName("Wood");
        Contact.EnterAddressLine1("45 Main Street");
        Contact.EnterPostalCode("803123");
        Contact.EnterCity("Auckland");
        Contact.ClickOnNextFromContact();
        String BlankStateValidation = Contact.GetValidationMessage();
        System.out.println("BlankStateValidation :"+ BlankStateValidation);
        assertEquals(BlankStateValidation, "State is required");
    }

    @Test
    public void ValidContactDetailAndProcess() throws Exception
    {
        ContactPage Contact = new ContactPage(driver);
        PaymentPage Payment = new PaymentPage(driver);
        Contact.EnterFirstName("John");
        Contact.EnterLastName("Wood");
        Contact.EnterAddressLine1("45 Main Street");
        Contact.EnterPostalCode("803123");
        Contact.EnterCity("Auckland");
        Contact.SelectState("Queensland");
        Contact.ClickOnNextFromContact();
        Thread.sleep(5000);
        Payment.IsRedirectOnPaymentPage();
    }

    @Test
    public void BlankCardHolderNameValidation() throws Exception
    {
        PaymentPage Payment = new PaymentPage(driver);
        Payment.ClickOnNextFromPayment();
        String BlankCardHolderNameValidation = Payment.GetValidationMessage();
        System.out.println("BlankCardHolderNameValidation :"+ BlankCardHolderNameValidation);
        assertEquals(BlankCardHolderNameValidation, "Cardholder Name is required");

    }

    @Test
    public void BlankCardTypeValidation() throws Exception
    {
        PaymentPage Payment = new PaymentPage(driver);
        Payment.EnterCardHolderName("John Wood");
        Payment.ClickOnNextFromPayment();
        String BlankCardTypeValidation = Payment.GetValidationMessage();
        System.out.println("BlankCardTypeValidation :"+ BlankCardTypeValidation);
        assertEquals(BlankCardTypeValidation, "Card Type is required");
    }

    @Test
    public void BlankCardNumberValidation() throws Exception
    {
        PaymentPage Payment = new PaymentPage(driver);
        Payment.SelectCardTypeMaster();
        Payment.ClickOnNextFromPayment();
        String BlankCardNoValidation = Payment.GetValidationMessage();
        System.out.println("BlankCardNoValidation :"+ BlankCardNoValidation);
        assertEquals(BlankCardNoValidation, "Card Number is required");
    }

    @Test
    public void BlankCardCVVValidation() throws Exception
    {
        PaymentPage Payment = new PaymentPage(driver);
        Payment.EnterCardNumber("5871282855551923");
        Payment.ClickOnNextFromPayment();
        String BlankCardCVVValidation = Payment.GetValidationMessage();
        System.out.println("BlankCardCVVValidation :"+ BlankCardCVVValidation);
        assertEquals(BlankCardCVVValidation, "Card CVV is required");
    }

    @Test
    public void BlankCardExpiryMonthValidation() throws Exception
    {
        PaymentPage Payment = new PaymentPage(driver);
        Payment.EnterCardCVV("761");
        Payment.ClickOnNextFromPayment();
        String BlankCardExpiryMonthValidation = Payment.GetValidationMessage();
        System.out.println("BlankCardExpiryMonthValidation :"+ BlankCardExpiryMonthValidation);
        assertEquals(BlankCardExpiryMonthValidation, "Card Expiry Month is required");
    }

    @Test
    public void BlankCardExpiryYearValidation() throws Exception
    {
        PaymentPage Payment = new PaymentPage(driver);
        Payment.SelectCardExpMonth("June");
        Payment.ClickOnNextFromPayment();
        String BlankCardExpiryYearValidation = Payment.GetValidationMessage();
        System.out.println("BlankCardExpiryYearValidation :"+ BlankCardExpiryYearValidation);
        assertEquals(BlankCardExpiryYearValidation, "Card Expiry Year is required");
    }

    @Test
    public void ValidPaymentDetailAndProcess() throws Exception
    {
        PaymentPage Payment = new PaymentPage(driver);
        TNCPage TNC = new TNCPage(driver);
        Payment.EnterCardHolderName("John Mar");
        Payment.SelectCardTypeVisa();
        Payment.EnterCardNumber("7611245888124533");
        Payment.EnterCardCVV("761");
        Payment.SelectCardExpMonth("June");
        Payment.EnterCardExpYear("2030");
        Payment.ClickOnNextFromPayment();
        Thread.sleep(5000);
        TNC.IsRedirectOnTNCPage();
    }

    @Test
    public void ValidWithoutReadTNC() throws Exception
    {

        TNCPage TNC = new TNCPage(driver);
        TNC.ClickOnSubmit();
        String AgreeReadTNCValidation = TNC.GetValidationMessage();
        System.out.println("AgreeReadTNCValidation :"+ AgreeReadTNCValidation);
        assertEquals(AgreeReadTNCValidation, "You must first read all the terms and conditions before submitting");
    }

    @Test
    public void ValidWithoutSelectTNC() throws Exception
    {

        TNCPage TNC = new TNCPage(driver);
        TNC.ScrollOnTNCRead();
        TNC.ClickOnSubmit();
        String AgreeSelectTNCValidation = TNC.GetValidationMessage();
        System.out.println("AgreeSelectTNCValidation :"+ AgreeSelectTNCValidation);
        assertEquals(AgreeSelectTNCValidation, "You must agree to these terms and conditions before submitting");
    }

    @Test
    public void SelectTNCAndSubmit() throws Exception
    {

        TNCPage TNC = new TNCPage(driver);
        WelcomePage Complete = new WelcomePage(driver);
        TNC.SelectAgreeTermsAndCondition();
        TNC.ClickOnSubmit();
        Thread.sleep(6000);

        System.out.println(Complete.GetConfirmationMessage());

    }

    @AfterTest
    public void Quit()
    {
      driver.quit();
    }

}
