package ru.vasilyev.citytask.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cities")
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "population")
    private int population;

    @Column(name = "metro")
    private boolean isMetro;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "city")
    private List<Location> locations;

}
