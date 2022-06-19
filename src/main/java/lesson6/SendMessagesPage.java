package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Sveta
 */
public class SendMessagesPage extends BasePage {
    public SendMessagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="next_you")
    private WebElement sendMessageNextButton;

    private final static String NEXT_YOU_BUTTON_LOCATOR = "next_you";
    public SuccessRegistrationPage transationSendMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(NEXT_YOU_BUTTON_LOCATOR)));
        sendMessageNextButton.click();
        return new SuccessRegistrationPage(driver);
    }
}
