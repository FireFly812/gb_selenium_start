package lesson7;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

/**
 * @author Sveta
 */
public class AdditionalAllureSteps implements WebDriverListener {
    private static Logger logger = LoggerFactory.getLogger("Selenium");

    public void beforeClick(WebElement element) {
        logger.info("Клик по элементу " + element.getText());
        Allure.step("Клик по элементу " + element.getText());
    }

    public void beforeQuit(WebDriver driver) {
        Allure.addAttachment("Скриншот перед закрытием браузера", new ByteArrayInputStream(
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
