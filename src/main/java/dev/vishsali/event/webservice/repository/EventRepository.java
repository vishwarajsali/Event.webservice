package dev.vishsali.event.webservice.repository;

import dev.vishsali.event.webservice.entity.Event;
import org.springframework.data.repository.ListCrudRepository;

public interface EventRepository extends ListCrudRepository<Event, Integer> {
}
