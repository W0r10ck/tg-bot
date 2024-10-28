package telegramm.bot.sotis.domain.service.sotis;

import telegramm.bot.sotis.api.model.request.CitiesRequest;
import telegramm.bot.sotis.api.model.request.InfoRequest;
import telegramm.bot.sotis.api.model.response.AspectInfoResponse;
import telegramm.bot.sotis.api.model.response.CoordinateInfoResponse;
import telegramm.bot.sotis.api.model.response.FullInfoResponse;
import telegramm.bot.sotis.api.model.response.HouseInfoResponse;

import java.util.List;

public interface SotisGetService {

    List<String> takeCities(CitiesRequest source);

    FullInfoResponse getFullInfo(InfoRequest source);
    CoordinateInfoResponse getCoordinateInfo(InfoRequest source);
    HouseInfoResponse getHouseInfo(InfoRequest source);
    AspectInfoResponse getAspectsInfo(InfoRequest source);

}
