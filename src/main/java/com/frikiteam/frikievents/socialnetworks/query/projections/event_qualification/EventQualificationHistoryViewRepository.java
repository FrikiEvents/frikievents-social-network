package com.frikiteam.frikievents.socialnetworks.query.projections.event_qualification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventQualificationHistoryViewRepository extends JpaRepository<EventQualificationHistoryView, String> {
    @Query(value = "SELECT * FROM event_qualification_history_view WHERE event_qualification_history_id = (SELECT MAX(event_qualification_history_id) FROM event_qualification_history_view WHERE event_qualification_id = :eventQualificationId)", nativeQuery = true)
    Optional<EventQualificationHistoryView> getLastByEventQualificationId(String eventQualificationId);

    @Query(value = "SELECT * FROM event_qualification_history_view WHERE event_qualification_id = :eventQualificationId ORDER BY created_at", nativeQuery = true)
    List<EventQualificationHistoryView> getHistoryByEventQualificationId(String eventQualificationId);
}
