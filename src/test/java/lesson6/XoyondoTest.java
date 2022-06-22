package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Story;
import lesson7.AdditionalAllureSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

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
        driver = new EventFiringDecorator(new AdditionalAllureSteps()).decorate(new ChromeDriver());
        driver.get("https://xoyondo.com/");
    }

    @Test
    @Story("Проверка создания формы регистрации")
    void createRegistrationForm() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectRegistrationFormOnMenu()
                .createRegistration()
                .fillDateAndTimeRegistration("1:00 PM", "2:00 PM")
                .transationAdvancedOption()
                .transationSendMessage()
                .checkSuccesMessage();
    }

    @AfterEach
    void killDriver() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            Allure.addAttachment("Элемент лога браузера", logEntry.getMessage());
        }
        driver.quit();
    }
}
