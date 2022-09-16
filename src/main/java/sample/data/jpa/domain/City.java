package sample.data.jpa.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    private Long id;

    @NotNull
    private String country;

    @NotNull
    private String name;

    @NotNull
    private String state;

    @NotNull
    private String map;
}
