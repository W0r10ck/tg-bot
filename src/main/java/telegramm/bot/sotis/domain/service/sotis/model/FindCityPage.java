package telegramm.bot.sotis.domain.service.sotis.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.Duration.ofSeconds;

public class FindCityPage {

    public WebDriver driver;

    public FindCityPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//div[contains(@id,'getcity')]")
    private WebElement findCityInputPage;

    @FindBy(xpath = "//input[contains(@id,'fndCity')]")
    private WebElement findCityInput;

    @FindBy(xpath = "//div[contains(@class,'list')]/div")
    private List<WebElement> findCities;

    public void inputCityForSearch(final String city) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(50L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'getcity')]")));
        findCityInput.sendKeys(city);
    }

    public List<String> getCities(final String city) {
        inputCityForSearch(city);
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(50L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'list')]/div")));
        if (findCities.isEmpty()) {
            return Collections.emptyList();
        }
        return findCities.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickCity(final String cityShort, final String cityFull) {
        inputCityForSearch(cityShort);
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(50L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'list')]/div")));

        findCities.stream().filter(e -> e.getText().contains(cityFull)).findFirst().ifPresent(WebElement::click);
    }


}
