package m.kash.seatify.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import m.kash.seatify.enums.Genre;
import m.kash.seatify.enums.Language;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "MOVIES")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie extends BaseModel{

    @Column(nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    private Date releaseDate;

    @OneToMany
    @JsonIgnore
    private List<Show> shows = new ArrayList<>();
}
