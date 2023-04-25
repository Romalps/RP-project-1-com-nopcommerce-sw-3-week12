package computer;

import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* ● Create the package name computer
1. Create class “TestSuite”
Write the following Test:
1.Test name verifyProductArrangeInAlphaBaticalOrder()
1.1 Click on Computer Menu.
1.2 Click on Desktop
1.3 Select Sort By position "Name: Z to A"
1.4 Verify the Product will arrange in Descending order.
2. Test name verifyProductAddedToShoppingCartSuccessFully()
2.1 Click on Computer Menu.
2.2 Click on Desktop
2.3 Select Sort By position "Name: A to Z"
2.4 Click on "Add To Cart"
2.5 Verify the Text "Build your own computer"
2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
2.7.Select "8GB [+$60.00]" using Select class.
2.8 Select HDD radio "400 GB [+$100.00]"
2.9 Select OS radio "Vista Premium [+$60.00]"
2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
[+$5.00]"
2.11 Verify the price "$1,475.00"
2.12 Click on "ADD TO CARD" Button.
2.13 Verify the Message "The product has been added to your shopping cart" on Top
green Bar
After that close the bar clicking on the cross button.
2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
2.15 Verify the message "Shopping cart"
2.16 Change the Qty to "2" and Click on "Update shopping cart"
2.17 Verify the Total"$2,950.00"
2.18 click on checkbox “I agree with the terms of service”
2.19 Click on “CHECKOUT”
2.20 Verify the Text “Welcome, Please Sign In!”
2.21Click on “CHECKOUT AS GUEST” Tab
2.22 Fill the all mandatory field
2.23 Click on “CONTINUE”
2.24 Click on Radio Button “Next Day Air($0.00)”
2.25 Click on “CONTINUE”
2.26 Select Radio Button “Credit Card”
2.27 Select “Master card” From Select credit card dropdown
2.28 Fill all the details
2.29 Click on “CONTINUE”
2.30 Verify “Payment Method” is “Credit Card”
2.32 Verify “Shipping Method” is “Next Day Air”
2.33 Verify Total is “$2,950.00”
2.34 Click on “CONFIRM”
2.35 Verify the Text “Thank You”
2.36 Verify the message “Your order has been successfully processed!”
2.37 Click on “CONTINUE”
2.37 Verify the text “Welcome to our store”
* */
public class TestSuite extends Utility {

    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: Z to A");
        // Get all the product and store them in list
        List<WebElement> productList = driver.findElements(By.className("product-item"));
        List<String> productName = new ArrayList<>();

        for (WebElement product : productList) {

            productName.add(product.findElement(By.className("product-title")).getText());

        }
        // sort the product names in descending order
        List<String> sortedProductNameList = new ArrayList<>(productName);
        Collections.sort(sortedProductNameList, Collections.reverseOrder());

        // Verify that the product names are arranged in descending order
        String expectedMessage = "Lenovo IdeaCentre 600 All-in-One PC";
        WebElement actualTextElement = driver.findElement(By.xpath("//a[normalize-space()='Lenovo IdeaCentre 600 All-in-One PC']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        //2.1 Find and Click on Computer menu element
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        // 2.2 Find and clock on Desktop element
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        // 2.3 Select sort by position 'Name: A to Z' element
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: A to Z");
        Thread.sleep(1000);
        //2.4 Find and click on Add to Cart element
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"));
        // 2.5 Verify the Text "Build your own computer"
        String expectedMessage = "Build your own computer";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[normalize-space()='Build your own computer']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Build your own computer text displayed", expectedMessage, actualMessage);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");

        // 2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");

        // 2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

        // 2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));

        // 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(4000);
        // 2.11 Verify the price "$1,475.00"
        String expectedMessage_1 = "$1,475.00";
        WebElement actualTextElement_1 = driver.findElement(By.id("price-value-1"));
        String actualMessage_1 = actualTextElement_1.getText();
        Assert.assertEquals("The Price $1475.00 displayed", expectedMessage_1, actualMessage_1);
        Thread.sleep(1000);
        // 2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.id("add-to-cart-button-1"));

        // 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessage_2 = "The product has been added to your shopping cart";
        WebElement actualTextElement_2 = driver.findElement(By.className("content"));
        String actualMessage_2 = actualTextElement_2.getText();
        Assert.assertEquals("This product has been added to your shopping cart message displayed", expectedMessage_2, actualMessage_2);
        // After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        // 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        WebElement shoppingCart = driver.findElement(By.xpath("//span[@class='cart-label']"));
        WebElement goToCart = driver.findElement(By.xpath("//button[normalize-space()='Go to cart']"));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();
        // 2.15 Verify the message "Shopping cart"
        String expectedMessage_3 = "Shopping cart";
        WebElement actualTextElement_3 = driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        String actualMessage_3 = actualTextElement_3.getText();
        Assert.assertEquals("Shopping Cart message displayed", expectedMessage_3, actualMessage_3);
        // 2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        // 2.17 Verify the Total"$2,950.00"
        String expectedMessage_4 = "$2,950.00";
        WebElement actualTextElement_4 = driver.findElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        String actualMessage_4 = actualTextElement_4.getText();
        Assert.assertEquals("$2950.00 Total displayed", expectedMessage_4, actualMessage_4);
        Thread.sleep(1000);
        // 2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        Thread.sleep(1000);

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedMessage_5 = "Welcome, Please Sign In!";
        WebElement actualTextElement_5 = driver.findElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        String actualMessage_5 = actualTextElement_5.getText();
        Assert.assertEquals("Welcome, Please Sign In! Text displayed", expectedMessage_5, actualMessage_5);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        // 2.22 Fill the all mandatory field
        // Find the First name field element and send firstname element
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Prime543");
        // Find the Last name field element and send last name element
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Tester");
        //Find Email field element and send email element
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "prime543tester@gmail.com");
        // Select the country from country field element
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        // Find City field element and send city element
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        //Find address1 field element and send address1 element
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "123,High Road");
        //Find postcode field element and send postcode element
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA5 7AL");
        //Find phone number field element and send phone number element
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07412589000");

        // 2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        // 2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        // 2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        // click on continue button
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        // 2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");

        // 2.28 Fill all the details
        // Find cardholder name field element and send element
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Prime543");
        // Find card number field element and send element
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5105105105105100");

        // Find Expiration date field element and send element
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "10");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2028");

        //  Find Card code field element and send element
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "456");

        // 2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        // 2.30 Verify “Payment Method” is “Credit Card”
        String expectedMessage_6 = "Credit Card";
        WebElement actualTextElement_6 = driver.findElement(By.xpath("//span[normalize-space()='Credit Card']"));
        String actualMessage_6 = actualTextElement_6.getText();
        Assert.assertEquals("Payment Method is Credit card displayed", expectedMessage_6, actualMessage_6);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedMessage_7 = "Next Day Air";
        WebElement actualTextElement_7 = driver.findElement(By.xpath("//span[normalize-space()='Next Day Air']"));
        String actualMessage_7 = actualTextElement_7.getText();
        Assert.assertEquals("Shipping Method is Next Day Air is displayed", expectedMessage_7, actualMessage_7);

        //2.33 Verify Total is “$2,950.00”
        String expectedMessage_8 = "$2,950.00";
        WebElement actualTextElement_8 = driver.findElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        String actualMessage_8 = actualTextElement_8.getText();
        Assert.assertEquals("Total $2,950.00 is displayed", expectedMessage_8, actualMessage_8);

        // 2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        // 2.35 Verify the Text “Thank You”
        String expectedMessage_9 = "Thank you";
        WebElement actualTextElement_9 = driver.findElement(By.xpath("//h1[normalize-space()='Thank you']"));
        String actualMessage_9 = actualTextElement_9.getText();
        Assert.assertEquals("Thank you text is displayed", expectedMessage_9, actualMessage_9);
        //2.36 Verify the message “Your order has been successfully processed!”
        String expectedMessage_10 = "Your order has been successfully processed!";
        WebElement actualTextElement_10 = driver.findElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        String actualMessage_10 = actualTextElement_10.getText();
        Assert.assertEquals("Your order has been successfully processed! is displayed", expectedMessage_10, actualMessage_10);

        //2.37 Click on “CONTINUE”
    clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.37 Verify the text “Welcome to our store”
        String expectedMessage_11 = "Welcome to our store";
        WebElement actualTextElement_11 = driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        String actualMessage_11 = actualTextElement_11.getText();
        Assert.assertEquals("Welcome to our store is displayed", expectedMessage_11, actualMessage_11);

    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}
