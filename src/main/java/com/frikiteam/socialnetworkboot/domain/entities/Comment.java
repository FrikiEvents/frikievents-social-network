package com.frikiteam.socialnetworkboot.domain.entities;

import com.frikiteam.socialnetworkboot.domain.values.CommentId;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comments")
@Data
public class Comment {
  @EmbeddedId
  @AttributeOverrides({
      @AttributeOverride(name = "id", column = @Column(name = "id", columnDefinition = "BINARY(16)"))
  })
  private CommentId id;

  @Column(name = "content")
  private String content;

  public Comment(CommentId commentId, String content) {
    this.id = commentId;
    this.content = content;
  }

  public Comment() {

  }

  /*falta agregar user y event*/
}
