package com.frikiteam.socialnetworkboot.application.repositories;


import com.frikiteam.socialnetworkboot.domain.entities.EventQualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventQualificationRepository <T extends EventQualification> extends JpaRepository<T, UUID> {
}
