package com.frikiteam.socialnetworkboot.api;

import com.frikiteam.socialnetworkboot.application.notification.ApplicationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ApiController {
  public static ResponseEntity<Object> ok(Object result) {
    return new ResponseEntity(Envelope.ok(result), HttpStatus.OK);
  }

  public static ResponseEntity<Object> created(Object result) {
    return new ResponseEntity(Envelope.ok(result), HttpStatus.CREATED);
  }

  public static ResponseEntity<Object> error(List<ApplicationError> errors)
  {
    return new ResponseEntity(Envelope.error(errors), HttpStatus.BAD_REQUEST);
  }

  public static ResponseEntity<Object> serverError()
  {
    return new ResponseEntity(Envelope.serverError(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  public static ResponseEntity<Object> notFound()
  {
    return new ResponseEntity(Envelope.notFound(), HttpStatus.NOT_FOUND);
  }
}