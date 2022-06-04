package com.frikiteam.frikievents.socialnetworks.command.application.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterCommentResponse {
  private String commentId;
  private String content;

  public RegisterCommentResponse(String eventQualificationId, Integer starsQuantity) {
  }

  public RegisterCommentResponse(String commentId, String content) {
    this.commentId = commentId;
    this.content = content;
  }
}
