package com.frikiteam.socialnetworkboot.api;

import com.frikiteam.socialnetworkboot.application.notification.ApplicationError;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class Envelope {
  private Object result;
  private List<ApplicationError> errors;

  private Envelope(Object result, List<ApplicationError> errors) {
    this.result = result;
    this.errors = errors;
  }

  public static Envelope ok(Object result)
  {
    return new Envelope(result, new ArrayList<ApplicationError>());
  }

  public static Envelope error(List<ApplicationError> errors)
  {
    if (errors == null) errors = new ArrayList<>();
    return new Envelope(null, errors);
  }

  public static Envelope serverError()
  {
    List<ApplicationError> errors = new ArrayList<ApplicationError>();
    ApplicationError error = new ApplicationError("Internal Server Error", null);
    errors.add(error);
    return new Envelope(null, errors);
  }

  public static Envelope notFound()
  {
    List<ApplicationError> errors = new ArrayList<ApplicationError>();
    ApplicationError error = new ApplicationError("entity not found", null);
    errors.add(error);
    return new Envelope(null, errors);
  }
}