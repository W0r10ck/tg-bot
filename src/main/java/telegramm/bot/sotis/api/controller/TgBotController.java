package telegramm.bot.sotis.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import telegramm.bot.sotis.api.model.request.CitiesRequest;
import telegramm.bot.sotis.api.model.request.InfoRequest;
import telegramm.bot.sotis.api.model.response.*;

@RequestMapping("/bot-sotis")
public interface TgBotController {

    @PostMapping("/city")
    CitiesResponse takeCities(@RequestBody CitiesRequest request);

    @PostMapping("/full-info")
    FullInfoResponse getFullInfo(@RequestBody InfoRequest request);

    @PostMapping("/coordinate-info")
    CoordinateInfoResponse getCoordinateInfo(@RequestBody InfoRequest request);

    @PostMapping("/house-info")
    HouseInfoResponse getHouseInfo(@RequestBody InfoRequest request);

    @PostMapping("/aspects-info")
    AspectInfoResponse getAspectsInfo(@RequestBody InfoRequest request);
}
