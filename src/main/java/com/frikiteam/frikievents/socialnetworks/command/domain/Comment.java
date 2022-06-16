package com.frikiteam.frikievents.socialnetworks.command.domain;

import com.frikiteam.frikievents.socialnetworks.command.domain.valueObjects.CommentId;
import com.frikiteam.frikievents.socialnetworks.contracts.commands.EditComment;
import com.frikiteam.frikievents.socialnetworks.contracts.commands.RegisterComment;
import com.frikiteam.frikievents.socialnetworks.contracts.events.CommentEdited;
import com.frikiteam.frikievents.socialnetworks.contracts.events.CommentRegistered;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class Comment {
  @AggregateIdentifier
  private String commentId;

  private String content;


  public Comment() {
  }

  @CommandHandler
  public Comment(RegisterComment command) {
    CommentId commentId1 = CommentId.of(UUID.fromString(command.getCommentId()));

    apply(
        new CommentRegistered(
                commentId1,
            command.getContent()
            )
    );
  }

  @CommandHandler
  public Comment(EditComment command) {
    apply(
        new CommentEdited(
            command.getCommentId(),
            command.getContent()
        )
    );
  }

  @EventSourcingHandler
  protected void on(CommentRegistered event) {
    this.commentId = event.getCommentId().toString();
    this.content = event.getContent();
  }

  @EventSourcingHandler
  protected void on(CommentEdited event) {
    this.content = event.getContent();
  }
}
