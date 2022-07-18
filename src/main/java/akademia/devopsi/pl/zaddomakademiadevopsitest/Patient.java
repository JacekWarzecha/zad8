package akademia.devopsi.pl.zaddomakademiadevopsitest;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="patient")
public class Patient {
    @Id
    private Long pesel;
    @NotNull
    @NotEmpty
    @Length(max=50)
    private String name;
    @NotEmpty
    @Length(max=80)
    private String surname;
    @Length(min=9, max=11)
    private String telephone;
    private String comments;

}
