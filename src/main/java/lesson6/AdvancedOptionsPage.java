package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Sveta
 */
public class AdvancedOptionsPage extends BasePage {
    public AdvancedOptionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "next")
    private WebElement advancedOptionsNextButton;

    private final static String NEXT_BUTTON_LOCATOR = "next";

    @Step("Страница Расширенные опции и переход на страницу отпраки сообщения")
    public SendMessagesPage transationAdvancedOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(NEXT_BUTTON_LOCATOR)));
        advancedOptionsNextButton.click();
        return new SendMessagesPage(driver);
    }
}
