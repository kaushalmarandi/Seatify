package m.kash.seatify.dtos;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class ShowEntryDto {

    private Time showStartTime;
    private Date showDate;
    private int screenId;
    private Integer movieId;
}
