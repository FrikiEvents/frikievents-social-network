package com.frikiteam.socialnetworkboot.application.handlers;

import com.frikiteam.frikievents.common.application.Notification;
import com.frikiteam.frikievents.common.application.Result;
import com.frikiteam.socialnetworkboot.application.commands.RegisterComment;
import com.frikiteam.socialnetworkboot.application.repositories.CommentRepository;
import com.frikiteam.socialnetworkboot.domain.entities.Comment;
import com.frikiteam.socialnetworkboot.domain.values.CommentId;
import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegisterCommentHandler {
  private CommentRepository commentRepository;

  public RegisterCommentHandler(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  @CommandHandler
  public Result<Comment, Notification> handle(RegisterComment registerComment) {
    Notification notification = new Notification();
    CommentId commentId = CommentId.of(UUID.fromString(registerComment.getId()));
    if (notification.hasErrors()){
      return Result.failure(notification);
    }
    Comment comment = new Comment(commentId, registerComment.getContent());
    commentRepository.save(comment);
    return Result.success(comment);
  }
}
