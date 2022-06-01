package ru.vasilyev.citytask.service;

import ru.vasilyev.citytask.entity.City;

public interface CityService {

    City createCity(String cityName, int population, boolean metro, String country);

    City updateCity(Long id, int population, boolean metro);

    City getCityById(Long id);

    void deleteCityById(Long id);
}
