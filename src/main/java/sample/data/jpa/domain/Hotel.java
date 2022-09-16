package sample.data.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id")
    private Long id;

    @NotNull
    @Column(name = "city_id")
    private Integer city;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String zip;
}
