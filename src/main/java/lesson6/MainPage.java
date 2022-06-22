package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sveta
 */
public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'cmp_button cmp_button_bg cmp_button_font_color']")
    private WebElement acceptButton;

    @FindBy(xpath = "//span[@class='nav-link-create']")
    private WebElement createButton;

    @FindBy(xpath = "//a[@href='/signup/create/new']")
    private WebElement signupLink;

    @Step("Вызов создания формы регистрации из главного меню")
    public CreateRegistrationFormPage selectRegistrationFormOnMenu() {
        acceptButton.click();
        createButton.click();
        signupLink.click();
        return new CreateRegistrationFormPage(driver);
    }
}
