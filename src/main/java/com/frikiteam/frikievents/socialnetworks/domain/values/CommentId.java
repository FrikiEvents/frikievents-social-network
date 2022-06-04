package com.frikiteam.frikievents.socialnetworks.domain.values;

import lombok.Value;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Value(staticConstructor = "of")
public class CommentId implements Serializable {
  private UUID id;

  public CommentId(UUID id) {
    this.id = id;
  }

  protected CommentId() {
    this.id = UUID.randomUUID();
  }
}
