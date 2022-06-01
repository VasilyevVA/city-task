package ru.vasilyev.citytask.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vasilyev.citytask.dto.CityDto;
import ru.vasilyev.citytask.entity.City;
import ru.vasilyev.citytask.service.CityService;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<City> createCity(@RequestBody CityDto cityDto) {
        City city = cityService.createCity(cityDto.getCityName(), cityDto.getPopulation(), cityDto.isMetro(), cityDto.getCountry());

        return ResponseEntity.status(HttpStatus.CREATED).body(city);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public City updateCity(@RequestBody City cityDto) {
        return cityService.updateCity(cityDto.getId(), cityDto.getPopulation(), cityDto.isMetro());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<City> getCityById(@PathVariable("id") Long id) {
        City city = cityService.getCityById(id);
        return ResponseEntity.ok(city);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCityById(@PathVariable("id") Long id) {
        cityService.deleteCityById(id);
    }
}
