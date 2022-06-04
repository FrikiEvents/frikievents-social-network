package com.frikiteam.frikievents.socialnetworks.command.application.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterCommentRequest {
  private String content;

  public RegisterCommentRequest() {
  }

  public RegisterCommentRequest(String content) {
    this.content = content;
  }
}
