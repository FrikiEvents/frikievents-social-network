package com.frikiteam.frikievents.socialnetworks.command.application.services;

import com.frikiteam.frikievents.common.application.Notification;
import com.frikiteam.frikievents.common.application.Result;
import com.frikiteam.frikievents.common.application.ResultType;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.CommentEditRequest;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.request.CommentRegisterRequest;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.CommentEditResponse;
import com.frikiteam.frikievents.socialnetworks.command.application.dtos.response.CommentRegisterResponse;
import com.frikiteam.socialnetworkcontracts.socialNetwork.contracts.commands.EditComment;
import com.frikiteam.socialnetworkcontracts.socialNetwork.contracts.commands.RegisterComment;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class CommentApplicationService {
  private final CommandGateway commandGateway;

  public CommentApplicationService(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  public Result<CommentRegisterResponse, Notification> registerComment(CommentRegisterRequest commentRegisterRequest)
      throws Exception {
    String commentId = UUID.randomUUID().toString();
    RegisterComment registerComment = new RegisterComment(
        commentId,
        commentRegisterRequest.getContent()
    );
    CompletableFuture<Object> future = commandGateway.send(registerComment);
    CompletableFuture<ResultType> result = future.handle((ok, ex) -> (ex != null) ? ResultType.FAILURE : ResultType.SUCCESS);
    ResultType resultType = result.get();
    if (resultType == ResultType.FAILURE) {
      throw new Exception("Error while registering comment");
    }
    CommentRegisterResponse commentRegisterResponse = new CommentRegisterResponse(
        registerComment.getCommentId(),
        registerComment.getContent()
    );
    return Result.success(commentRegisterResponse);
  }

  public Result<CommentEditResponse, Notification> updateComment(String id, CommentEditRequest commentEditRequest) throws Exception {
    EditComment editComment = new EditComment(
        id,
        commentEditRequest.getContent()
    );
    CompletableFuture<Object> future = commandGateway.send(editComment);
    CompletableFuture<ResultType> result = future.handle((ok, ex) -> (ex != null) ? ResultType.FAILURE : ResultType.SUCCESS);
    ResultType resultType = result.get();
    if (resultType == ResultType.FAILURE) {
      throw new Exception("Error while updating comment");
    }
    CommentEditResponse commentEditResponse = new CommentEditResponse(
        editComment.getCommentId(),
        editComment.getContent()
    );
    return Result.success(commentEditResponse);
  }
}