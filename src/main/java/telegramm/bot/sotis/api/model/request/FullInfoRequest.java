package telegramm.bot.sotis.api.model.request;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FullInfoRequest {

    private String male;
    private String name;
    private String day;
    private String month;
    private String year;
    private String hour;
    private String minute;
    private String second;
    private String cityShort;
    private String cityFull;
}
