package telegramm.bot.sotis.domain.service.sotis.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;
import telegramm.bot.sotis.api.model.request.CitiesRequest;
import telegramm.bot.sotis.api.model.request.FullInfoRequest;
import telegramm.bot.sotis.api.model.response.CoordinateTable;
import telegramm.bot.sotis.api.model.response.FullInfoResponse;
import telegramm.bot.sotis.domain.service.sotis.SotisGetService;
import telegramm.bot.sotis.domain.service.sotis.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public static ResultPage resultPage;

    public List<String> planetCodeList = Arrays.asList(
            "'PLANET','0:11'",
            "'PLANET','0:7'",
            "'PLANET','0:56'",
            "'PLANET','0:5'",
            "'PLANET','0:4'",
            "'PLANET','0:12'",
            "'PLANET','0:0'",
            "'PLANET','0:2'",
            "'PLANET','0:1'",
            "'PLANET','0:9'",
            "'PLANET','0:6'",
            "'PLANET','0:8'"
    );


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
            findCityPage.clickCity(source.getCityShort(), source.getCityFull());
            newCardPage.clickOk();

            return FullInfoResponse.init()
                    .setCoordinateTable(getCoordinateTableList())
                    .setHousesInfo(getHousesInfo())
                    .build();
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
        resultPage = new ResultPage(driver);
        driver.get("https://sotis-online.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, SECONDS);

        mainPage.clickHoroscopeBtn();
        mainPage.clickCreateNewBtn();

        dialogPage.clickSingleCardBtn();
    }

    private List<CoordinateTable> getCoordinateTableList() {
        var result = new ArrayList<CoordinateTable>();

        for (int i = 0; i < 16; i++) {
            result.add(
                    CoordinateTable.init()
                            .setLeft(resultPage.getLeftPlanetByIndex(i + 1))
                            .setMiddle(resultPage.getMiddlePlanetByIndex(i + 1))
                            .setRight(resultPage.getRightPlanetByIndex(i + 1))
                            .build()
            );
        }
        for (int i = 0; i < 12; i++) {
            result.add(
                    CoordinateTable.init()
                            .setLeft(resultPage.getLeftHouseByIndex(i + 1))
                            .setMiddle(resultPage.getMiddleHouseByIndex(i + 1))
                            .setRight(resultPage.getRightHouseByIndex(i + 1))
                            .build()
            );
        }

        return result;
    }

    private List<String> getHousesInfo() {
        return planetCodeList.stream()
                .map(t -> {
                            var result = "";
                            resultPage.clickPlanet(t);
                            result = resultPage.getInfoAboutHouse();
                            resultPage.clickExitPlanet();
                            return result;
                        }
                ).collect(Collectors.toList());

    }
}
