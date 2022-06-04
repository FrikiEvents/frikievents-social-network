package com.frikiteam.frikievents.socialnetworks.query.projections;

import com.frikiteam.socialnetworkcontracts.socialNetwork.contracts.events.CommentEdited;
import com.frikiteam.socialnetworkcontracts.socialNetwork.contracts.events.CommentRegistered;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

  @EventHandler
  public void on(CommentEdited event) {
    Optional<CommentView> commentViewOptional = commentViewRepository.findById(event.getCommentId());
    if (commentViewOptional.isPresent()) {
      CommentView commentView = commentViewOptional.get();
      commentView.setContent(event.getContent());
      commentViewRepository.save(commentView);
    }
  }
}
