package m.kash.bookmyshowoct24.models;

import jakarta.persistence.*;
import lombok.*;
import m.kash.bookmyshowoct24.enums.SeatType;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "TICKET")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket extends BaseModel{
    private int totalTicketsPrice;
    private String bookedSeats;

    private SeatType seatType;

    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private Show show;

    @JoinColumn
    @ManyToOne
    private User user;
}
