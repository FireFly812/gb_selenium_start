package lesson6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sveta
 */
public class SuccessRegistrationPage extends BasePage {
    public SuccessRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'alert-info')]/span")
    private WebElement successMesage;

    @Step("Регистрация успешно создана")
    public void checkSuccesMessage() {
        Assertions.assertEquals("Вы успешно создали список регистрации. Спасибо, что выбрали Xoyondo.",
                successMesage.getText());
    }
}
