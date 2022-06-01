package ru.vasilyev.citytask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "locations")
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date_of_building")
    private LocalDate dateOfBuilding;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "city")
    @JsonIgnore
    private City city;

}
