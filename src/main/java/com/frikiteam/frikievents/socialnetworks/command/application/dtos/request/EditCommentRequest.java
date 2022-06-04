package com.frikiteam.frikievents.socialnetworks.command.application.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditCommentRequest {
    private String content;

  public EditCommentRequest(String content) {
    this.content = content;
  }

  public EditCommentRequest() {
  }
}
