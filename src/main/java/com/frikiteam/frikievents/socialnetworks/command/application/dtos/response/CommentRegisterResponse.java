package com.frikiteam.frikievents.socialnetworks.command.application.dtos.response;

import lombok.Value;

@Value
public class CommentRegisterResponse {
  private String commentId;
  private String content;
}
