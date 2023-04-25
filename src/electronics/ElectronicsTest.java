package electronics;

import io.netty.util.collection.ByteObjectHashMap;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/*
● Create package Electronics
1. Create the class ElectronicsTest
Write the following test
1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
1.1 Mouse Hover on “Electronics” Tab
1.2 Mouse Hover on “Cell phones” and click
1.3 Verify the text “Cell phones”
2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
2.1 Mouse Hover on “Electronics” Tab
2.2 Mouse Hover on “Cell phones” and click
2.3 Verify the text “Cell phones”
2.4 Click on List View Tab
2.5 Click on product name “Nokia Lumia 1020” link
2.6 Verify the text “Nokia Lumia 1020”
2.7 Verify the price “$349.00”
2.8 Change quantity to 2
2.9 Click on “ADD TO CART” tab
2.10 Verify the Message "The product has been added to your shopping cart" on Top
green Bar
After that close the bar clicking on the cross button.
2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
2.12 Verify the message "Shopping cart"
2.13 Verify the quantity is 2
2.14 Verify the Total $698.00
2.15 click on checkbox “I agree with the terms of service”
2.16 Click on “CHECKOUT”
2.17 Verify the Text “Welcome, Please Sign In!”
2.18 Click on “REGISTER” tab
2.19 Verify the text “Register”
2.20 Fill the mandatory fields
2.21 Click on “REGISTER” Button
2.22 Verify the message “Your registration completed”
2.23 Click on “CONTINUE” tab
2.24 Verify the text “Shopping card”
2.25 click on checkbox “I agree with the terms of service”
2.26 Click on “CHECKOUT”
2.27 Fill the Mandatory fields
2.28 Click on “CONTINUE”
2.29 Click on Radio Button “2nd Day Air ($0.00)”
2.30 Click on “CONTINUE”
2.31 Select Radio Button “Credit Card”
2.32 Select “Visa” From Select credit card dropdown
2.33 Fill all the details
2.34 Click on “CONTINUE”
2.35 Verify “Payment Method” is “Credit Card”
2.36 Verify “Shipping Method” is “2nd Day Air”
2.37 Verify Total is “$698.00”
2.38 Click on “CONFIRM”
2.39 Verify the Text “Thank You”
2.40 Verify the message “Your order has been successfully processed!”
2.41 Click on “CONTINUE”
2.42 Verify the text “Welcome to our store”
2.43 Click on “Logout” link
2.44 Verify the URL is “https://demo.nopcommerce.com/”
 */
public class ElectronicsTest extends Utility {

    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {

        //1.1 Mouse Hover on “Electronics” Tab
        //1.2 Mouse Hover on “Cell phones” and click
        actionsMethodForMouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"), By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        Thread.sleep(1000);
        //1.3 Verify the text “Cell phones”
        assertMethod(By.xpath("//h1[normalize-space()='Cell phones']"), "Cell phones");

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        // 2.1 Mouse Hover on “Electronics” Tab
        //2.2 Mouse Hover on “Cell phones” and click
        actionsMethodForMouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"), By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        Thread.sleep(1000);

        //2.3 Verify the text “Cell phones”
        assertMethod(By.xpath("//h1[normalize-space()='Cell phones']"), "Cell phones");
        Thread.sleep(1000);
        // 2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        Thread.sleep(2000);
        // 2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));

        //2.6 Verify the text “Nokia Lumia 1020”
        assertMethod(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"), "Nokia Lumia 1020");

        //2.7 Verify the price “$349.00”
        assertMethod(By.xpath("//span[@id='price-value-20']"), "$349.00");

        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        Thread.sleep(2000);
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        assertMethod(By.xpath("//p[@class='content']"), "The product has been added to your shopping cart");
        Thread.sleep(1000);
        // After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));
        Thread.sleep(1000);
        // 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        actionsMethodForMouseHover(By.xpath("//span[@class='cart-label']"), By.xpath("//button[normalize-space()='Go to cart']"));

        //2.12 Verify the message "Shopping cart"
        assertMethod(By.xpath("//h1[normalize-space()='Shopping cart']"), "Shopping cart");
        Thread.sleep(3000);
        //******************************************************
        //2.13 Verify the quantity is 2
       // assertMethod(By.xpath("(//tbody//td[@class='quantity']//input[@id='itemquantity11236']"), "2");

        //2.14 Verify the Total $698.00
        assertMethod(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"), "$698.00");
        Thread.sleep(2000);
        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(1000);
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        assertMethod(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"), "Welcome, Please Sign In!");
        Thread.sleep(2000);
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));

        //2.19 Verify the text “Register”
        assertMethod(By.xpath("//h1[normalize-space()='Register']"), "Register");

        //2.20 Fill the mandatory fields
        // Find First name field element and send element
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Prime54");
        // Find Last name field element and send element
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Tester");
        // Find Email field element and send element
        sendTextToElement(By.xpath("//input[@id='Email']"), "prime541tester324@gmail.com");
        // Find Password field element and send element
        sendTextToElement(By.xpath("//input[@id='Password']"), "Prime54tester32");
        // Find Confirm Password field element and send element
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Prime54tester32");
        Thread.sleep(1000);
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        assertMethod(By.xpath("//div[@class='result']"), "Your registration completed");
        Thread.sleep(1000);
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //2.24 Verify the text “Shopping cart”
        assertMethod(By.xpath("//h1[normalize-space()='Shopping cart']"), "Shopping cart");
        clickOnElement(By.xpath("//a[normalize-space()='Log in']"));
        sendTextToElement(By.xpath("//input[@id='Email']"),"prime541tester324@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"),"Prime54tester32");
        clickOnElement(By.xpath("//button[normalize-space()='Log in']"));


        Thread.sleep(1000);
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(1000);
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.27 Fill the Mandatory fields

        // Find Country field element and select element
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "India");

        // Find City field element and send element
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Mumbai");
        // Find Address1 field element and send element
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "45,Joohu Lane");
        // Find Postcode field element and send element
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "385698");
        // Find Phone Number field element and send element
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "0981385698");

        Thread.sleep(1000);
        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        Thread.sleep(1000);
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        Thread.sleep(1000);
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep(1000);
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(1000);
        // Click on continue button
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");

        //2.33 Fill all the details
        // Find Cardholder name field element and send element
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Prime");
        // Find Card Number field element and send element
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555555555554444");
        // Find Expiration date field element and select element
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "10");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2027");
        // Find Card code number name field element and send element
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "789");
        Thread.sleep(1000);
        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.35 Verify “Payment Method” is “Credit Card”
        assertMethod(By.xpath("//span[normalize-space()='Credit Card']"), "Credit Card");
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        assertMethod(By.xpath("//span[normalize-space()='2nd Day Air']"), "2nd Day Air");
        //2.37 Verify Total is “$698.00”
        assertMethod(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"), "$698.00");
        Thread.sleep(1000);
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.39 Verify the Text “Thank You”
        assertMethod(By.xpath("//h1[normalize-space()='Thank you']"), "Thank you");
        //2.40 Verify the message “Your order has been successfully processed!”
        assertMethod(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"), "Your order has been successfully processed!");
        Thread.sleep(1000);
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.42 Verify the text “Welcome to our store”
        assertMethod(By.xpath("//h2[normalize-space()='Welcome to our store']"), "Welcome to our store");
        Thread.sleep(1000);
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[normalize-space()='Log out']"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://demo.nopcommerce.com/");


    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
