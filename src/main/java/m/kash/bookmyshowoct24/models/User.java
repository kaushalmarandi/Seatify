package m.kash.bookmyshowoct24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Builder
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel{
    private String name;
    private String email;
    private String password;
}
