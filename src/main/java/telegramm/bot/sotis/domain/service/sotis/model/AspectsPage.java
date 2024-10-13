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

public class AspectsPage {

    public WebDriver driver;

    public AspectsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//table[contains(@id,'atbl')]")
    private WebElement aspectsTable;

    @FindBy(xpath = "//table[contains(@id,'atbl')]//td[contains(@data-t,'')][text()]")
    private List<WebElement> findCities;

    public List<String> getAspects() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(50L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@id,'atbl')]")));
        if (findCities.isEmpty()) {
            return Collections.emptyList();
        }
        return findCities.stream().map(t -> t.getAttribute("data-t")).collect(Collectors.toList());
    }


}
