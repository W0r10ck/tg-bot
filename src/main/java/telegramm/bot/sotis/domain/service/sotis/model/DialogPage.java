package telegramm.bot.sotis.domain.service.sotis.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class DialogPage {

    public WebDriver driver;

    public DialogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[contains(@id,'cont')]")
    private WebElement mainElement;


    @FindBy(xpath = "//a[h5[contains(text(),'Одинарная карта')]]")
    private WebElement singleCardBtn;

    public boolean isViewDialogPage() {
        return mainElement.isDisplayed();
    }

    public void clickSingleCardBtn() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'newchart')]")));
        singleCardBtn.click();
    }
}
