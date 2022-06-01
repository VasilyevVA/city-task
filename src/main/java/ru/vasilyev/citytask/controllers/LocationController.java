package ru.vasilyev.citytask.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vasilyev.citytask.dto.LocationDto;
import ru.vasilyev.citytask.entity.Location;
import ru.vasilyev.citytask.service.LocationService;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Location> createLocation(@RequestBody LocationDto locationDto) {
        Location location = locationService.createLocation(locationDto.getTitle(), locationDto.getDateOfBuilding(), locationDto.getText(), locationDto.getCityId());

        return ResponseEntity.status(HttpStatus.CREATED).body(location);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Location updateLocation(@RequestBody Location locationDto) {

        return locationService.updateLocation(locationDto.getId(), locationDto.getText());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Location> getLocationById(@PathVariable("id") Long id) {
        Location location = locationService.getLocationById(id);
        return ResponseEntity.ok(location);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteLocationById(@PathVariable("id") Long id) {
        locationService.deleteLocationById(id);
    }

}
