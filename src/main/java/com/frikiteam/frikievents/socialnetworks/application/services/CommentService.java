package com.frikiteam.frikievents.socialnetworks.application.services;

import com.frikiteam.frikievents.common.application.Notification;
import com.frikiteam.frikievents.common.application.Result;
import com.frikiteam.frikievents.common.application.ResultType;
import com.frikiteam.frikievents.socialnetworks.application.commands.RegisterComment;
import com.frikiteam.frikievents.socialnetworks.application.dtos.CommentRegisterRequest;
import com.frikiteam.frikievents.socialnetworks.application.dtos.CommentRegisterResponse;
import com.frikiteam.frikievents.socialnetworks.application.dtos.CommentView;
import com.frikiteam.frikievents.socialnetworks.application.queries.GetCommentByIdQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class CommentService {
  private final CommandGateway commandGateway;
  private final QueryGateway queryGateway;

  public CommentService(CommandGateway commandGateway, QueryGateway queryGateway) {
    this.commandGateway = commandGateway;
    this.queryGateway = queryGateway;
  }

  public Result<CommentRegisterResponse, Notification> registerComment(CommentRegisterRequest request) throws Exception {
    String commentId = UUID.randomUUID().toString();
    RegisterComment registerComment = new RegisterComment(commentId, request.getContent());
    CompletableFuture<Object> future = commandGateway.send(registerComment);
    CompletableFuture<ResultType> result = future.handle((ok, ex) -> (ex != null) ? ResultType.FAILURE : ResultType.SUCCESS);
    ResultType resultType = result.get();
    if (resultType == ResultType.FAILURE) {
      throw new Exception("Error while registering comment");
    }
    CommentRegisterResponse response = new CommentRegisterResponse(
      registerComment.getId(),
      registerComment.getContent()
    );
    return Result.success(response);
  }

  public CommentView getById(String id) throws Exception {
    CompletableFuture<CommentView> future = queryGateway.query(new GetCommentByIdQuery(id), ResponseTypes.instanceOf(CommentView.class));
    CompletableFuture<ResultType> result = future.handle((ok, ex) -> (ex != null) ? ResultType.FAILURE : ResultType.SUCCESS);
    ResultType resultType = result.get();
    if (resultType == ResultType.FAILURE) {
      throw new Exception("Error while getting comment");
    }
    return future.get();
  }
}
