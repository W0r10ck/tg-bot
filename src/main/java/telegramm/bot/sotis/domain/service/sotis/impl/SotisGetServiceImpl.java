package telegramm.bot.sotis.domain.service.sotis.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;
import telegramm.bot.sotis.api.model.request.CitiesRequest;
import telegramm.bot.sotis.api.model.request.FullInfoRequest;
import telegramm.bot.sotis.api.model.response.FullInfoResponse;
import telegramm.bot.sotis.domain.service.sotis.SotisGetService;
import telegramm.bot.sotis.domain.service.sotis.model.DialogPage;
import telegramm.bot.sotis.domain.service.sotis.model.FindCityPage;
import telegramm.bot.sotis.domain.service.sotis.model.MainPage;
import telegramm.bot.sotis.domain.service.sotis.model.NewCardPage;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
@Service
@RequiredArgsConstructor
public class SotisGetServiceImpl implements SotisGetService {

    public static WebDriver driver;
    public static MainPage mainPage;
    public static NewCardPage newCardPage;
    public static DialogPage dialogPage;
    public static FindCityPage findCityPage;





    @Override
    public List<String> takeCities(CitiesRequest source) {
        try {
            openNewCardPage();

            newCardPage.clickPlaceInput();

            var result = findCityPage.getCities(source.getCity());

            driver.quit();

            return result;
        } finally {
            driver.quit();
        }
    }

    @Override
    public FullInfoResponse getFullInfo(FullInfoRequest source) {
        try {
            openNewCardPage();

            newCardPage.selectMale(source.getMale());
            newCardPage.inputName(source.getName());
            newCardPage.inputDay(source.getDay());
            newCardPage.inputMonth(source.getMonth());
            newCardPage.inputYear(source.getYear());
            newCardPage.inputHour(source.getHour());
            newCardPage.inputMinute(source.getMinute());
            newCardPage.inputSec(source.getSecond());
            newCardPage.clickPlaceInput();
            findCityPage.clickCity(source.getCityShort(),source.getCityFull());
            newCardPage.clickOk();



            return null;
        } finally {
            driver.quit();
        }

    }


    private void openNewCardPage() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        newCardPage = new NewCardPage(driver);
        dialogPage = new DialogPage(driver);
        findCityPage = new FindCityPage(driver);
        driver.get("https://sotis-online.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10,SECONDS);

        mainPage.clickHoroscopeBtn();
        mainPage.clickCreateNewBtn();

        dialogPage.clickSingleCardBtn();
    }
}
