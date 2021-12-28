package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;

public class HomePageTest extends CommonConditions{
    @Test
    public void findWithoutDataTest(){
        final String EXPECTED_ERROR = "Укажите город отправления";
        String actualError = new HomePage(driver)
                .openPage()
                .pressFindButton()
                .getErrorText();
        Assert.assertEquals(actualError, EXPECTED_ERROR);
    }
}
