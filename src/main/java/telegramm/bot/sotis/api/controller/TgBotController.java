package telegramm.bot.sotis.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import telegramm.bot.sotis.api.model.request.CitiesRequest;
import telegramm.bot.sotis.api.model.request.FullInfoRequest;
import telegramm.bot.sotis.api.model.response.CitiesResponse;
import telegramm.bot.sotis.api.model.response.FullInfoResponse;

@RequestMapping("/bot-sotis")
public interface TgBotController {

    @PostMapping("/city")
    CitiesResponse takeCities(@RequestBody CitiesRequest request);

    @PostMapping("/full-info")
    FullInfoResponse getFullInfo(@RequestBody FullInfoRequest request);
}
