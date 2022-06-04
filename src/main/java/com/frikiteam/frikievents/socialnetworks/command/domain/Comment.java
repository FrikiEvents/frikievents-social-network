package com.frikiteam.frikievents.socialnetworks.command.domain;

import com.frikiteam.frikievents.socialnetworks.contracts.commands.EditComment;
import com.frikiteam.frikievents.socialnetworks.contracts.commands.RegisterComment;
import com.frikiteam.frikievents.socialnetworks.contracts.events.CommentEdited;
import com.frikiteam.frikievents.socialnetworks.contracts.events.CommentRegistered;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

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
    apply(
        new CommentRegistered(
            command.getCommentId(),
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
    this.commentId = event.getCommentId();
    this.content = event.getContent();
  }

  @EventSourcingHandler
  protected void on(CommentEdited event) {
    this.content = event.getContent();
  }
}
