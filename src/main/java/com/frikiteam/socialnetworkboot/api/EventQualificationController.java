package com.frikiteam.socialnetworkboot.api;


import com.frikiteam.frikievents.common.api.ApiController;
import com.frikiteam.frikievents.common.application.Notification;
import com.frikiteam.frikievents.common.application.Result;
import com.frikiteam.socialnetworkboot.application.dtos.EventQualificationRegisterRequest;
import com.frikiteam.socialnetworkboot.application.dtos.EventQualificationRegisterResponse;
import com.frikiteam.socialnetworkboot.application.dtos.EventQualificationView;
import com.frikiteam.socialnetworkboot.application.services.EventQualificationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event_qualification")
public class EventQualificationController {
    private final EventQualificationService eventQualificationService;

    public EventQualificationController(EventQualificationService eventQualificationService) {
        this.eventQualificationService = eventQualificationService;
    }

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registerEventQualification(@RequestBody EventQualificationRegisterRequest eventQualificationRegisterRequest) {
        try {
            Result<EventQualificationRegisterResponse, Notification> result = eventQualificationService.registerEventQualification(eventQualificationRegisterRequest);
            if (result.isSuccess()) {
                return ApiController.created(result.getSuccess());
            }
            return ApiController.error(result.getFailure().getErrors());
        } catch (Exception e) {
            return ApiController.serverError();
        }
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getEventQualificationById(@PathVariable("id") String id) {
        try {
            EventQualificationView eventQualificationView = eventQualificationService.getById(id);
            return ApiController.ok(eventQualificationView);
        } catch(Exception e) {
            return ApiController.serverError();
        }
    }

}
