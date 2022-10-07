package sample.data.jpa.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.jvnet.fastinfoset.stax.LowLevelFastInfosetStreamWriter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    private Long id;

    @OneToMany(mappedBy = "city")
    private List<Hotel> hotels;

//    @JsonProperty(value="country")
    private String country;

    private String name;

    private String state;

    private String map;
}
