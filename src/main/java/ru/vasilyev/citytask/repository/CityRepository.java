package ru.vasilyev.citytask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasilyev.citytask.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
