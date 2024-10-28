package m.kash.bookmyshowoct24.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import m.kash.bookmyshowoct24.enums.ScreenType;


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
    private List<ScreenSeat> screenSeats = new ArrayList<>();

    @OneToMany
    private List<Show> shows = new ArrayList<>();


}
