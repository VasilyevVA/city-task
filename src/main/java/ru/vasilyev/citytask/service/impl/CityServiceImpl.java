package ru.vasilyev.citytask.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vasilyev.citytask.entity.City;
import ru.vasilyev.citytask.repository.CityRepository;
import ru.vasilyev.citytask.service.CityService;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public City createCity(String cityName, int population, boolean metro, String country) {
        City city = new City();
        city.setCityName(cityName);
        city.setPopulation(population);
        city.setMetro(metro);
        city.setCountry(country);

        return cityRepository.save(city);
    }

    @Override
    public City updateCity(Long id, int population, boolean metro) {
        City city = cityRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("cityById not exist"));
        city.setPopulation(population);
        city.setMetro(metro);

        return cityRepository.save(city);
    }

    @Override
    public City getCityById(Long id) {

        return cityRepository.findById(id).get();
    }

    @Override
    public void deleteCityById(Long id) {

        cityRepository.deleteById(id);
    }
}
