package com.frikiteam.frikievents.socialnetworks.query.projections.comment;

import com.frikiteam.frikievents.socialnetworks.contracts.events.CommentRegistered;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class CommentViewProjection {
  private final CommentViewRepository commentViewRepository;

  public CommentViewProjection(CommentViewRepository commentViewRepository) {
    this.commentViewRepository = commentViewRepository;
  }

  @EventHandler
  public void on(CommentRegistered event) {
    CommentView commentView = new CommentView(event.getCommentId(), event.getContent());
    commentViewRepository.save(commentView);
  }
}
