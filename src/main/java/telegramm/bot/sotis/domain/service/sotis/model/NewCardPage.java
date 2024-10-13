package telegramm.bot.sotis.domain.service.sotis.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static java.util.Objects.isNull;

public class NewCardPage {

    public WebDriver driver;

    public NewCardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[contains(@id,'enter')]")
    private WebElement mainElementPage;

    @FindBy(xpath = "//div[contains(@class,'sex')]/select")
    private Select maleDropDown;

    @FindBy(xpath = "//input[contains(@name,'name0')]")
    private WebElement nameInput;

    @FindBy(xpath = "//input[contains(@name,'day0')]")
    private WebElement dayInput;

    @FindBy(xpath = "//input[contains(@name,'month0')]")
    private WebElement monthInput;

    @FindBy(xpath = "//input[contains(@name,'year0')]")
    private WebElement yearInput;

    @FindBy(xpath = "//input[contains(@name,'hour0')]")
    private WebElement hourInput;

    @FindBy(xpath = "//input[contains(@name,'min0')]")
    private WebElement minInput;

    @FindBy(xpath = "//input[contains(@name,'sec0')]")
    private WebElement secInput;

    @FindBy(xpath = "//input[contains(@name,'cityid0_n')]")
    private WebElement placeInput;

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    private WebElement okBtn;


    public void clickPlaceInput() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(50L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'enter')]")));
        placeInput.click();
    }


    public void selectMale(final String male) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(50L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'sex')]/select")));

        if (isNull(maleDropDown)) {
            maleDropDown = new Select(driver.findElement(By.xpath("//div[contains(@class,'sex')]/select")));
        }

        if (male.equals("М")) {
            maleDropDown.selectByValue("m");
        }

        if (male.equals("Ж")) {
            maleDropDown.selectByValue("w");
        }
    }

    public void inputName(final String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void inputDay(final String day) {
        dayInput.clear();
        dayInput.sendKeys(day);
    }

    public void inputMonth(final String month) {
        monthInput.clear();
        monthInput.sendKeys(month);
    }

    public void inputYear(final String year) {
        yearInput.clear();
        yearInput.sendKeys(year);
    }

    public void inputHour(final String hour) {
        hourInput.clear();
        hourInput.sendKeys(hour);
    }

    public void inputMinute(final String minute) {
        minInput.clear();
        minInput.sendKeys(minute);
    }

    public void inputSec(final String sec) {
        secInput.clear();
        secInput.sendKeys(sec);
    }

    public void clickOk() {
        okBtn.click();
    }

}
