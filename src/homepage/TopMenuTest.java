package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/*
Project-1 com-nopcommerce-sw-3
baseUrl: https://demo.nopcommerce.com/
Requirement:
● Create the package homepage
1. create class "TopMenuTest"
1.1 create method with name "selectMenu" it has one parameter name "menu" of type
string
1.2 This method should click on the menu whatever name is passed as parameter.
1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
select the Menu and click on it and verify the page navigation.
 */
public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        // open the browser
        openBrowser(baseUrl);
    }

    @Test
    public void verifyPageNavigation() {
        selectMenu("Computers");
        String expectedPage = "Computers";
        String actualPage= getTextFromElement(By.linkText("Computers"));

        Assert.assertEquals("Page navigation ", expectedPage, actualPage);
    }

    public void selectMenu(String menu) {
        // find the element and click
        clickOnElement(By.linkText(menu));

    }


    @After
    public void tearDown() {
        // Closing the browser
        closeBrowser();
    }
}
