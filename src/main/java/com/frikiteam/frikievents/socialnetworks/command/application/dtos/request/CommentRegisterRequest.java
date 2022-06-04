package com.frikiteam.frikievents.socialnetworks.command.application.dtos.request;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value
public class CommentRegisterRequest {
  private String content;
}
