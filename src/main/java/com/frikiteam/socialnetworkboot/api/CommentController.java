package com.frikiteam.socialnetworkboot.api;

import com.frikiteam.frikievents.common.api.ApiController;
import com.frikiteam.frikievents.common.application.Notification;
import com.frikiteam.frikievents.common.application.Result;
import com.frikiteam.socialnetworkboot.application.dtos.CommentRegisterRequest;
import com.frikiteam.socialnetworkboot.application.dtos.CommentRegisterResponse;
import com.frikiteam.socialnetworkboot.application.dtos.CommentView;
import com.frikiteam.socialnetworkboot.application.services.CommentService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {
  private final CommentService commentService;

  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> registerComment(@RequestBody CommentRegisterRequest commentRegisterRequest) {
    try {
      Result<CommentRegisterResponse, Notification> result = commentService.registerComment(commentRegisterRequest);
      if (result.isSuccess()) {
        return ApiController.created(result.getSuccess());
      }
      return ApiController.error(result.getFailure().getErrors());
    } catch (Exception e) {
      return ApiController.serverError();
    }
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getCommentById(@PathVariable("id") String id) {
    try {
      CommentView commentView = commentService.getById(id);
      return ApiController.ok(commentView);
    } catch(Exception e) {
      return ApiController.serverError();
    }
  }

}
