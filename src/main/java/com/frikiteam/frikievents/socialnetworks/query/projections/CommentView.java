package com.frikiteam.frikievents.socialnetworks.query.projections;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class CommentView {
  @Id
  private String commentId;

  private String content;

  public CommentView() {
  }

  public CommentView(String commentId, String content) {
    this.commentId = commentId;
    this.content = content;
  }
}
