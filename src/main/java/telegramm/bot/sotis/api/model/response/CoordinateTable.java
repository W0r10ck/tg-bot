package telegramm.bot.sotis.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(builderMethodName = "init", setterPrefix = "set", toBuilder = true)
@AllArgsConstructor
public class CoordinateTable {

    private String left;

    private String middle;

    private String right;

}
