package com.frikiteam.frikievents.socialnetworks.application.repositories;


import com.frikiteam.frikievents.socialnetworks.domain.entities.EventFollows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventFollowsRepository <T extends EventFollows> extends JpaRepository<T, UUID> {
}
