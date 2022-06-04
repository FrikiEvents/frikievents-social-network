package com.frikiteam.frikievents.socialnetworks.application.queries;

import lombok.Data;

@Data
public class GetCommentByIdQuery {
    private String id;

  public GetCommentByIdQuery(String id) {
    this.id = id;
  }
}