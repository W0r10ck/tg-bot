package telegramm.bot.sotis.domain.service.sotis;

import telegramm.bot.sotis.api.model.request.CitiesRequest;
import telegramm.bot.sotis.api.model.request.FullInfoRequest;
import telegramm.bot.sotis.api.model.response.FullInfoResponse;

import java.util.List;

public interface SotisGetService {

    /**
     * Создание и сохранение металлической сделки
     *
     * @param source domain модель Сделки
     * @return domain модель созданной Сделки
     */
    List<String> takeCities(CitiesRequest source);

    /**
     * Получение списка доменных моделей сделок, с фильтрацией по предикату
     *
     * @param source предикат по которому будет отфильтрован итоговый список сделок
     * @return список доменных моделей сделок по металлу
     */
    FullInfoResponse getFullInfo(FullInfoRequest source);

}
