package com.frikiteam.frikievents.socialnetworks.query.projections.event_qualification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventQualificationViewRepository extends JpaRepository<EventQualificationView, String> {
}
