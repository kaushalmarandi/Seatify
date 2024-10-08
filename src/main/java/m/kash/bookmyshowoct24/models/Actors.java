package m.kash.bookmyshowoct24.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Actors extends BaseModel{
    private String name;
}
