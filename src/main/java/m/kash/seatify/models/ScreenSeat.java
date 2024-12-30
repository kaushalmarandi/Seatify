package m.kash.seatify.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import m.kash.seatify.enums.SeatType;
@Data
@Entity
@Table(name = "Screen_Seats")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScreenSeat extends BaseModel{

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    private Screen screen;
}

