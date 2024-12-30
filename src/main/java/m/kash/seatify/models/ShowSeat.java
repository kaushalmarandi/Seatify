package m.kash.seatify.models;
import jakarta.persistence.*;
import lombok.Data;
import m.kash.seatify.enums.SeatStatus;
import m.kash.seatify.enums.SeatType;

@Entity
@Data
@Table(name = "SHOW_SEATS")
public class ShowSeat extends BaseModel{

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private int price;
    @Enumerated(value = EnumType.STRING)
    private SeatStatus seatStatus;

    @ManyToOne
    private Show show;
}