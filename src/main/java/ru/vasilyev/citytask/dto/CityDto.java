package ru.vasilyev.citytask.dto;

import lombok.Data;

@Data
public class CityDto {
    private Long id;
    private String cityName;
    private int population;
    private boolean isMetro;
    private String country;
}
