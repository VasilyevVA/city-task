package ru.vasilyev.citytask.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vasilyev.citytask.entity.City;
import ru.vasilyev.citytask.entity.Location;
import ru.vasilyev.citytask.repository.LocationRepository;
import ru.vasilyev.citytask.service.CityService;
import ru.vasilyev.citytask.service.LocationService;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final CityService cityService;

    @Override
    public Location createLocation(String title, LocalDate dateOfBuilding, String text, Long cityId) {
        Location location = new Location();
        location.setTitle(title);
        location.setDateOfBuilding(dateOfBuilding);
        location.setText(text);
        location.setCity(cityService.getCityById(cityId));

        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Long id,String text) {
        Location location = locationRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("locationById not exist"));
        location.setText(text);
        return locationRepository.save(location);
    }

    @Override
    public Location getLocationById(Long id) {

        return locationRepository.findById(id).get();
    }

    @Override
    public void deleteLocationById(Long id) {

        locationRepository.deleteById(id);
    }
}
