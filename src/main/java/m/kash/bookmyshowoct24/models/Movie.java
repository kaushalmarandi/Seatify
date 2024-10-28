package m.kash.bookmyshowoct24.models;
import jakarta.persistence.*;
import lombok.*;
import m.kash.bookmyshowoct24.enums.Genre;
import m.kash.bookmyshowoct24.enums.Language;

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
    private List<Show> shows = new ArrayList<>();
}
