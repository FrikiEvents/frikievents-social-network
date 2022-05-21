package com.frikiteam.socialnetworkboot.application.repositories;

import com.frikiteam.socialnetworkboot.domain.entities.OrganizerFollows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganizerFollowsRepository <T extends OrganizerFollows> extends JpaRepository<T, UUID> {
}
