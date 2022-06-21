package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

/**
 * @author Sveta
 */
public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'cmp_button cmp_button_bg cmp_button_font_color']")
    private WebElement acceptButton;

    @FindBy(xpath = "//span[@class='nav-link-create']")
    private WebElement createButton;

    @FindBy(xpath = "//a[@href='/signup/create/new']")
    private WebElement signupLink;

    public CreateRegistrationFormPage selectRegistrationOnMenu(){
        acceptButton.click();
        createButton.click();
        signupLink.click();
        return new CreateRegistrationFormPage(driver);
    }

}
