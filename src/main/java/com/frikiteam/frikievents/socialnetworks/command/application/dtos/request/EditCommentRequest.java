package com.frikiteam.frikievents.socialnetworks.command.application.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditCommentRequest {

    private String commentId;
    private String content;

  public EditCommentRequest() {
  }

  public EditCommentRequest(String commentId, String content) {
    this.commentId = commentId;
    this.content = content;
  }
}
