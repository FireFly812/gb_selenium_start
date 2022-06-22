package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * @author Sveta
 */
public class SelectFormatAndSlotPage extends BasePage {
    public SelectFormatAndSlotPage(WebDriver driver) {
        super(driver);
    }

    //Выбрать "Участие Да/Нет"
    @FindBy(linkText = "Участие Да/Нет")
    private WebElement participationYesOrNoButton;

    //Поле выбора даты
    @FindBy(id = "picker-single-date")
    private WebElement dateField;

    //поле выбора времениначала
    @FindBy(id = "timepicker-start-single-date")
    private WebElement startTimeField;

    @FindBy(xpath = "//div[@id='timepicker-start-single-date_root']//ul/li")
    private List<WebElement> startTimeList;

    //поле выбора времени окончания
    @FindBy(id = "timepicker-end-single-date")
    private WebElement endTimeField;

    @FindBy(xpath = "//div[@id='timepicker-end-single-date_root']//ul/li")
    private List<WebElement> endTimeList;

    @FindBy(id = "single-date-next")
    private WebElement singleDateNextButton;

    @Step("Выбор даты и времени регистрации")
    public AdvancedOptionsPage fillDateAndTimeRegistration(String startTime, String endTime) {
        participationYesOrNoButton.click();
        //Выбрать дату
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("picker-single-date")));
        dateField.click();
        //выбор текущей даты
        driver.findElement(By.xpath(
                "//table[@id='picker-single-date_table']//div[contains(@class, 'highlighted')]"))
                .click();
        //выбрать время начала
        startTimeField.click();
        startTimeList.stream().filter(t -> t.getText().equalsIgnoreCase(startTime)).findFirst().get().click();
        //Выбрать время окончания
        endTimeField.click();
        endTimeList.stream().filter(t -> t.getText().equalsIgnoreCase(endTime)).findFirst().get().click();
        singleDateNextButton.click();
        return new AdvancedOptionsPage(driver);
    }
}
