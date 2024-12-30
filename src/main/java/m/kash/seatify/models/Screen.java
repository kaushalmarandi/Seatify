package m.kash.seatify.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import m.kash.seatify.enums.ScreenType;


import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "SCREENS")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Screen extends BaseModel{

    private String name;

    @Enumerated(value = EnumType.STRING)
    private ScreenType screenType;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ScreenSeat> screenSeats = new ArrayList<>();

    @OneToMany
    @JsonIgnore
    private List<Show> shows = new ArrayList<>();


}
