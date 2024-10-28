package telegramm.bot.sotis.api.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import telegramm.bot.sotis.api.controller.TgBotController;
import telegramm.bot.sotis.api.model.request.CitiesRequest;
import telegramm.bot.sotis.api.model.request.InfoRequest;
import telegramm.bot.sotis.api.model.response.*;
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
    public FullInfoResponse getFullInfo(InfoRequest request) {
        return sotisGetService.getFullInfo(request);
    }

    @Override
    public CoordinateInfoResponse getCoordinateInfo(InfoRequest request) {
        return sotisGetService.getCoordinateInfo(request);
    }

    @Override
    public HouseInfoResponse getHouseInfo(InfoRequest request) {
        return sotisGetService.getHouseInfo(request);
    }

    @Override
    public AspectInfoResponse getAspectsInfo(InfoRequest request) {
        return sotisGetService.getAspectsInfo(request);
    }
}
