package ru.vasilyev.citytask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasilyev.citytask.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
