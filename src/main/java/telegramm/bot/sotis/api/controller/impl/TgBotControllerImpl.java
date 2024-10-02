package telegramm.bot.sotis.api.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import telegramm.bot.sotis.api.controller.TgBotController;
import telegramm.bot.sotis.api.model.request.CitiesRequest;
import telegramm.bot.sotis.api.model.request.FullInfoRequest;
import telegramm.bot.sotis.api.model.response.CitiesResponse;
import telegramm.bot.sotis.api.model.response.FullInfoResponse;
import telegramm.bot.sotis.domain.service.sotis.SotisGetService;

@RestController
@RequiredArgsConstructor
public class TgBotControllerImpl implements TgBotController {

    private final SotisGetService sotisGetService;

    @Override
    public CitiesResponse takeCities(CitiesRequest request) {
        return new CitiesResponse(sotisGetService.takeCities(request));
    }

    @Override
    public FullInfoResponse getFullInfo(FullInfoRequest request) {
        return sotisGetService.getFullInfo(request);
    }
}
