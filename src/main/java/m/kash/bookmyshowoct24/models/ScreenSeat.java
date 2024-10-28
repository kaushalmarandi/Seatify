package m.kash.bookmyshowoct24.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import m.kash.bookmyshowoct24.enums.SeatType;
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

