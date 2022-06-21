package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * @author Sveta
 */
public class SeleniumStart {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://xoyondo.com/");
        WebElement acceptButton = driver
                .findElement(By.xpath("//div[@class = 'cmp_button cmp_button_bg cmp_button_font_color']"));
        acceptButton.click();
        WebElement createButton = driver.findElement(By.xpath("//span[@class='nav-link-create']"));
        createButton.click();
        WebElement signupLink = driver.findElement(By.xpath("//a[@href='/signup/create/new']"));
        signupLink.click();

        //ввести название списка регистрации
        WebElement inputSubject = driver.findElement(By.id("subject"));
        inputSubject.sendKeys("registration form");

        //ввести дополнительное описание
        WebElement inputDescription = driver.findElement(By.id("message"));
        inputDescription.sendKeys("description");

        //ввести имя
        WebElement inputName = driver.findElement(By.id("name"));
        inputName.sendKeys("Svetlana");

        //ввести e-mail
        WebElement inputEmail = driver.findElement(By.id("email"));
        inputEmail.sendKeys("qwerty@ya.ru");

        //нажать на кнопку "Далее"
        driver.findElement(By.xpath("//button[@type ='submit']")).click();

        //Выбрать "Участие Да/Нет"
        driver.findElement(By.linkText("Участие Да/Нет")).click();

        //Выбрать дату
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("picker-single-date")));
        driver.findElement(By.id("picker-single-date")).click();
        driver.findElement(By.xpath(
                "//table[@id='picker-single-date_table']//div[contains(@class, 'highlighted')]/parent::td/following-sibling::td[1]/div"))
                .click();

        //Выбрать время начала
        driver.findElement(By.id("timepicker-start-single-date")).click();
        List<WebElement> startTimeList = driver
                .findElements(By.xpath("//div[@id='timepicker-start-single-date_root']//ul/li"));
        for (WebElement option : startTimeList) {
            if ("1:00 PM".equals(option.getText().trim())) {
                option.click();
                break;
            }
        }

        //Выбрать врем окончания
        driver.findElement(By.id("timepicker-end-single-date")).click();
        List<WebElement> endTimeList = driver
                .findElements(By.xpath("//div[@id='timepicker-end-single-date_root']//ul/li"));
        for (WebElement option : endTimeList) {
            if ("2:00 PM".equals(option.getText().trim())) {
                option.click();
                break;
            }
        }

        //Нажать кнопку далее
        driver.findElement(By.id("single-date-next")).click();

        //Еще раз кнопку "Далее" на странице "Расширенные опции"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next")));
        driver.findElement(By.id("next")).click();

        //Еще раз кнопку "Далее" на странице "Отправить приглашение"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next_you")));
        driver.findElement(By.id("next_you")).click();

        //Список регистраций успешно создан
        String congratulationsText = driver.findElement(By.xpath("//div[contains(@class, 'alert-info')]/span"))
                .getText();
        Assertions.assertEquals("Вы успешно создали список регистрации. Спасибо, что выбрали Xoyondo.",
                congratulationsText);
        driver.quit();



    }
}
