package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sveta
 */
public class CreateRegistrationFormPage extends BasePage{

    public CreateRegistrationFormPage(WebDriver driver) {
        super(driver);
    }
    //Название списка регистрации
    @FindBy(id = "subject")
    public WebElement inputSubject;

    //дополнительное описание
    @FindBy(id = "message")
    public WebElement inputDescription;

    //имя
    @FindBy(id = "name")
    public WebElement inputName;

    //e-mail
    @FindBy(id = "email")
    public WebElement inputEmail;

    //кнопка "Далее"
    @FindBy(xpath = "//button[@type ='submit']")
    public WebElement nextButton;

    //Заполнение формы регистрации и нажатие кнопки "Далее"
    @Step("Заполнение формы регистрации и переход на страницу выбора формата и слотов")
    public SelectFormatAndSlotPage createRegistration() {
        inputSubject.sendKeys("registration form");
        inputDescription.sendKeys("description");
        inputName.sendKeys("Svetlana");
        inputEmail.sendKeys("qwerty@ya.ru");
        nextButton.click();
        return new SelectFormatAndSlotPage(driver);
    }
}
