package com.frikiteam.frikievents.socialnetworks.command.application.dtos.response;

import lombok.Value;

@Value
public class CommentEditResponse {
  private String commentId;
  private String content;
}
