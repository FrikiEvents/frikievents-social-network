package com.frikiteam.frikievents.socialnetworks.query.projections.comment;

import com.frikiteam.frikievents.socialnetworks.contracts.events.CommentEdited;
import com.frikiteam.frikievents.socialnetworks.contracts.events.CommentRegistered;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommentHistoryViewProjection {
  private final CommentHistoryViewRepository commentHistoryViewRepository;

  public CommentHistoryViewProjection(CommentHistoryViewRepository commentHistoryViewRepository) {
    this.commentHistoryViewRepository = commentHistoryViewRepository;
  }

  @EventHandler
  public void on(CommentRegistered event) {
    CommentHistoryView commentHistoryView = new CommentHistoryView(
        event.getCommentId(),
        event.getContent()
    );
    commentHistoryViewRepository.save(commentHistoryView);
  }

  @EventHandler
  public void on(CommentEdited event) {
    Optional<CommentHistoryView> commentHistoryViewOptional =
        commentHistoryViewRepository.getLastCommentHistoryByCommentId(event.getCommentId());
    if (commentHistoryViewOptional.isPresent()) {
      CommentHistoryView commentHistoryView = commentHistoryViewOptional.get();
      commentHistoryView.setContent(event.getContent());
      commentHistoryViewRepository.save(commentHistoryView);
    }
  }
}


