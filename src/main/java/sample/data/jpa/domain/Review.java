package sample.data.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private User user;

    @Column(name = "check_in_date")
    private String checkInDate;

    private Integer rating;

    @Column(name = "trip_type")
    private Integer tripType;

    private String title;

    private String details;
}
