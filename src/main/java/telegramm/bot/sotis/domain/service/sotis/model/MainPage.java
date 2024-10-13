package telegramm.bot.sotis.domain.service.sotis.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//li[contains(text(),'Гороскоп')]")
    private WebElement horoscopeBtn;


    @FindBy(xpath = "//li[contains(@data-mi,'new')]")
    private WebElement createNewBtn;


    @FindBy(xpath = "//li[contains(text(),'Инструменты')]")
    private WebElement instrumentsBtn;

    @FindBy(xpath = "//li[contains(@data-mi,'addAsptbl')]")
    private WebElement aspectsTableBtn;

    public void clickHoroscopeBtn() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Гороскоп')]")));
        horoscopeBtn.click();
    }

    public void clickInstrumentsBtn() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Инструменты')]")));
        instrumentsBtn.click();
    }

    public void clickCreateNewBtn() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@data-mi,'new')]")));
        createNewBtn.click();
    }

    public void clickAspectsTableBtn() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@data-mi,'addAsptbl')]")));
        aspectsTableBtn.click();
    }
}
