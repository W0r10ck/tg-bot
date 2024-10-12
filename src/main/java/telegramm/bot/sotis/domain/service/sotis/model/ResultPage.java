package telegramm.bot.sotis.domain.service.sotis.model;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
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

        return driver.findElement(
                By.xpath("//table[contains(@class,'coord')]//tr[" + indexTr + "]/td[" + 1 + "]")
        ).getText();
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
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(50L));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//*[name()='g' and @class='zodiak']"))
        );
        try {
            var planet = driver.findElement(
                    By.xpath("//*[name()='g' and @class='obj'][contains(@onclick,\"" + planetCode + "\")]")
            );
            planet.click();
        } catch (StaleElementReferenceException ex) {
            var planet = driver.findElement(
                    By.xpath("//*[name()='g' and @class='obj'][contains(@onclick,\"" + planetCode + "\")]")
            );
            planet.click();
        }
    }

    public String getInfoAboutHouse() {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(50L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@id,'cont')]//*[contains(text(),'дом')]"))
        );
        var result = driver.findElement(By.xpath("//div[contains(@id,'cont')]//*[contains(text(),'доме')]"))
                .getText();

        return changeHouse(result);
    }

    public void clickExitPlanet() {

        driver.findElement(By.xpath("//div[contains(@class,'close')]")).click();
    }

}
