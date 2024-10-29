package m.kash.bookmyshowoct24.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Show extends BaseModel{

    @ManyToOne
    private Movie movie;
    private Time startTime;
   // private Date endTime;
    @Temporal(TemporalType.DATE)
    private Date showDate;
    @ManyToOne
    private Screen screen;
    @Enumerated(EnumType.ORDINAL)

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeat> showSeats = new ArrayList<>();
}
