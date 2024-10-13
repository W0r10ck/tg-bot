package telegramm.bot.sotis.domain.service.sotis;

import telegramm.bot.sotis.api.model.request.CitiesRequest;
import telegramm.bot.sotis.api.model.request.FullInfoRequest;
import telegramm.bot.sotis.api.model.response.FullInfoResponse;

import java.util.List;

public interface SotisGetService {

    List<String> takeCities(CitiesRequest source);

    FullInfoResponse getFullInfo(FullInfoRequest source);

}
