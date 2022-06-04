package com.frikiteam.frikievents.socialnetworks.command.application.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditCommentResponse {
  private String commentId;
  private String content;

  public EditCommentResponse(String commentId, String content) {
    this.commentId = commentId;
    this.content = content;
  }

  public EditCommentResponse() {
  }
}
