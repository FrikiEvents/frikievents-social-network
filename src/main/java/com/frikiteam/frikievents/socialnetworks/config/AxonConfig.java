package com.frikiteam.frikievents.socialnetworks.config;

import com.frikiteam.frikievents.socialnetworks.domain.entities.Comment;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.modelling.command.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {
  @Bean
  public Repository<Comment> eventSourcingRepository(EventStore eventStore) {
    return EventSourcingRepository.builder(Comment.class)
        .eventStore(eventStore)
        .build();
  }
}
