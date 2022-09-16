package sample.data.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idx")
    private Long id;

    @NotNull
    @Column(name = "hotel_id")
    private Integer hotel;

    @NotNull
    @Column(name = "check_in_date")
    private String checkInDate;

    @NotNull
    private Integer rating;

    @NotNull
    @Column(name = "trip_type")
    private Integer tripType;

    @NotNull
    private String title;

    @NotNull
    private String details;
}
