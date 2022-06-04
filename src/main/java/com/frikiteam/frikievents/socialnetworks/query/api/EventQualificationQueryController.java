package com.frikiteam.frikievents.socialnetworks.query.api;

import com.frikiteam.frikievents.socialnetworks.query.projections.event_qualification.EventQualificationHistoryView;
import com.frikiteam.frikievents.socialnetworks.query.projections.event_qualification.EventQualificationHistoryViewRepository;
import com.frikiteam.frikievents.socialnetworks.query.projections.event_qualification.EventQualificationView;
import com.frikiteam.frikievents.socialnetworks.query.projections.event_qualification.EventQualificationViewRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events_qualification")
@Tag(name = "EventsQualification")
public class EventQualificationQueryController {
    private final EventQualificationViewRepository eventQualificationViewRepository;
    private final EventQualificationHistoryViewRepository eventQualificationHistoryViewRepository;

    public EventQualificationQueryController(EventQualificationViewRepository eventQualificationViewRepository, EventQualificationHistoryViewRepository eventQualificationHistoryViewRepository) {
        this.eventQualificationViewRepository = eventQualificationViewRepository;
        this.eventQualificationHistoryViewRepository = eventQualificationHistoryViewRepository;
    }

    @GetMapping("")
    @Operation(summary = "Get all Event Qualifications")
    public ResponseEntity<List<EventQualificationView>> getAll() {
        try {
            return new ResponseEntity<List<EventQualificationView>>(eventQualificationViewRepository.findAll(), HttpStatus.OK);
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Event Qaulification By Id")
    public ResponseEntity<EventQualificationView> getById(@PathVariable("id") String id) {
        try {
            Optional<EventQualificationView> eventQualificationViewOptional = eventQualificationViewRepository.findById(id);
            if (eventQualificationViewOptional.isPresent()) {
                return new ResponseEntity<EventQualificationView>(eventQualificationViewOptional.get(), HttpStatus.OK);
            }
            return new ResponseEntity("NOT_FOUND", HttpStatus.NOT_FOUND);
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/history/{id}")
    @Operation(summary = "Get event qualification history")
    public ResponseEntity<List<EventQualificationHistoryView>> getHistoryById(@PathVariable("id") String id) {
        try {
            List<EventQualificationHistoryView> events = eventQualificationHistoryViewRepository.getHistoryByEventQualificationId(id);
            return new ResponseEntity<List<EventQualificationHistoryView>>(events, HttpStatus.OK);
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
