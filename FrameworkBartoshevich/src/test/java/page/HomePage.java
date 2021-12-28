package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.StandardCharsets;

public class HomePage extends AbstractPage{

    private static final String PAGE_URL = "https://ecolines.by/by/ru";
    private static final String ERROR_MESSAGE = "//*[@id=\"search-form\"]//p[@class=\"help-block\"]";
    private static final String FIND_BUTTON = "//*[@id=\"ecolines-booking-form\"]//button[@class=\"btn btn-primary btn-lg\"]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public HomePage pressFindButton(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIND_BUTTON)))
                .click();
        return this;
    }

    public String getErrorText(){

        return new String(new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ERROR_MESSAGE)))
            .getText().getBytes(StandardCharsets.UTF_8));
    }
}
