package dev.vishsali.event.webservice.config;

import dev.vishsali.event.webservice.entity.Event;
import dev.vishsali.event.webservice.repository.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class BatchConfig {

    @Bean
    CommandLineRunner commandLineRunner(EventRepository eventRepository){
        return events -> {
            if(eventRepository.count() == 0){
                var event = new Event(
                        1,
                        "AWS",
                        "Join AWS Event",
                        LocalDate.of(2024, 2, 1),
                        LocalDate.of(2024, 2, 5),
                        LocalDate.now().minusDays(30),
                        LocalDate.now(),
                        "Las Vegas, NV",
                        "https://vishsali.dev");

                eventRepository.save(event);
                log.info("Event created: {}", event.getName());
            }
        };
    }

}
