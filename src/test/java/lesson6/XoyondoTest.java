package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Sveta
 */
public class XoyondoTest {
    WebDriver driver;

    @BeforeAll
    static void registeredDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://xoyondo.com/");
    }

    @Test
    void createRegistrationForm() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectRegistrationOnMenu()
                .createRegistration()
                .fillDateAndTimeRegistration("1:00 PM", "2:00 PM")
                .transationAdvancedOption()
                .transationSendMessage()
                .checkSuccesMessage();
    }

    @AfterEach
    void killDriver() {
        driver.quit();
    }
}
