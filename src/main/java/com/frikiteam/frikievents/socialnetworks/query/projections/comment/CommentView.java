package com.frikiteam.frikievents.socialnetworks.query.projections.comment;

import com.frikiteam.frikievents.socialnetworks.command.domain.valueObjects.CommentId;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.AggregateIdentifier;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CommentView {
  @AggregateIdentifier
  @EmbeddedId
  @AttributeOverrides({
          @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BINARY(16)"))
  })
  @Getter
  private CommentId id;

  private String content;

  public CommentView() {
  }

  public CommentView(CommentId commentId, String content) {
    setId(commentId);
    setContent(content);

  }
}
