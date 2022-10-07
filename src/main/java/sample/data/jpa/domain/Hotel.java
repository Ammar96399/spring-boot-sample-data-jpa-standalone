package sample.data.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long id;

    @ManyToOne
    private City city;

    private String name;

    private String address;

    private String zip;

    @OneToMany(mappedBy = "hotel")
    private List<Review> reviews;
}
