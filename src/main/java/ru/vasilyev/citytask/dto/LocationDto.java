package ru.vasilyev.citytask.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LocationDto {

    private Long id;
    private String title;
    private LocalDate dateOfBuilding;
    private String text;
    private Long cityId;

}
