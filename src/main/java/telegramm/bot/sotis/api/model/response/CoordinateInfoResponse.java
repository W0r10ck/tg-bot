package telegramm.bot.sotis.api.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder(builderMethodName = "init", setterPrefix = "set", toBuilder = true)
@AllArgsConstructor
public class CoordinateInfoResponse {

    private List<CoordinateTable> coordinateTable;
}
