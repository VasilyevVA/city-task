package ru.vasilyev.citytask.service;

import ru.vasilyev.citytask.entity.City;
import ru.vasilyev.citytask.entity.Location;

import java.time.LocalDate;

public interface LocationService {

    Location createLocation(String title, LocalDate dateOfBuilding, String text, Long cityId);

    Location updateLocation(Long id, String text);

    Location getLocationById(Long id);

    void deleteLocationById(Long id);
}
