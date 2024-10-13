package telegramm.bot.sotis.domain.service.sotis.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static telegramm.bot.sotis.domain.service.util.CommonUtils.changeHouse;

public class ResultPage {

    public WebDriver driver;

    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getLeftPlanetByIndex(Integer index) {
        try {
            var element = driver.findElement(
                    By.xpath("//table[contains(@class,'coord')]//tr[" + index + "]/th")
            );
            return element.getAttribute("data-t");
        } catch (StaleElementReferenceException ex) {
            var element = driver.findElement(
                    By.xpath("//table[contains(@class,'coord')]//tr[" + index + "]/th")
            );
            return element.getAttribute("data-t");
        }
    }

    public String getLeftHouseByIndex(Integer index) {

        return driver.findElement(
                By.xpath("//tbody[contains(@class,'house')]//tr[" + index + "]/th")
        ).getText();
    }

    public String getMiddlePlanetByIndex(Integer indexTr) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(40L));
        wait.until(
                presenceOfAllElementsLocatedBy(
                        By.xpath("//table[contains(@class,'coord')]//tr[" + indexTr + "]/td[" + 1 + "]")
                )
        );
        try {
            return driver.findElement(
                    By.xpath("//table[contains(@class,'coord')]//tr[" + indexTr + "]/td[" + 1 + "]")
            ).getText();
        } catch (StaleElementReferenceException e) {
            return driver.findElement(
                    By.xpath("//table[contains(@class,'coord')]//tr[" + indexTr + "]/td[" + 1 + "]")
            ).getText();
        }
    }

    public String getMiddleHouseByIndex(Integer indexTr) {

        return driver.findElement(
                By.xpath("//tbody[contains(@class,'house')]//tr[" + indexTr + "]/td[" + 1 + "]")
        ).getText();
    }

    public String getRightPlanetByIndex(Integer indexTr) {

        try {
            var element = driver.findElement(
                    By.xpath("//table[contains(@class,'coord')]//tr[" + indexTr + "]/td[" + 2 + "]")
            );
            return element.getText();
        } catch (StaleElementReferenceException ex) {
            var element = driver.findElement(
                    By.xpath("//table[contains(@class,'coord')]//tr[" + indexTr + "]/td[" + 2 + "]")
            );
            return element.getText();
        }
    }

    public String getRightHouseByIndex(Integer indexTr) {

        return driver.findElement(
                By.xpath("//tbody[contains(@class,'house')]//tr[" + indexTr + "]/td[" + 2 + "]")
        ).getText();
    }

    public void clickPlanet(String planetCode) {
        var xpath = "//*[name()='g' and @class='obj'][contains(@onclick,\"" + planetCode + "\")]";
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(40L));
        wait.until(presenceOfAllElementsLocatedBy(
                By.xpath("//*[name()='g' and @class='zodiak']"))
        );
        try {
            wait.until(elementToBeClickable(By.xpath(xpath))).click();

        } catch (StaleElementReferenceException ex) {
            wait.until(elementToBeClickable(By.xpath(xpath))).click();
            var planet = driver.findElement(By.xpath(xpath));

            new Actions(driver)
                    .moveToElement(planet)
                    .click()
                    .build()
                    .perform();
        }
    }

    public String getInfoAboutHouse() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(40L));
        wait.until(visibilityOfElementLocated(
                By.xpath("//div[contains(@id,'cont')]//*[contains(text(),'дом')]"))
        );
        var result = driver.findElement(By.xpath("//div[contains(@id,'cont')]//*[contains(text(),'доме')]"))
                .getText();

        return changeHouse(result);
    }

    public void clickExitPlanet() {
        driver.findElement(By.xpath("//div[contains(@class,'close')]")).click();
    }

    public void removeNotClickPlanet() {
        removeNotClickPlanet("'PLANET','0:-11'");
        removeNotClickPlanet("'PLANET','0:15'");
        removeNotClickPlanet("'PLANET','0:57'");
    }

    public void removeNotClickPlanet(final String planetCode) {
        var xpath = "//*[name()='g' and @class='obj'][contains(@onclick,\"" + planetCode + "\")]/*[name()='text']";

        driver.findElements(By.xpath(xpath))
                .forEach(t -> {
                            JavascriptExecutor executor = (JavascriptExecutor) driver;
                            executor.executeScript("arguments[0].remove();", t);
                        }
                );
    }
}
