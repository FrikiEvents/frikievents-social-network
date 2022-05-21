package com.frikiteam.socialnetworkboot.application.dtos;

import lombok.Data;

@Data
public class CommentEditRequest {
  private String id;
  private String content;
}
