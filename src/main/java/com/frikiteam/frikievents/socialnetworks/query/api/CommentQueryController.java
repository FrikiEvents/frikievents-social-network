package com.frikiteam.frikievents.socialnetworks.query.api;

import com.frikiteam.frikievents.socialnetworks.query.projections.comment.CommentHistoryView;
import com.frikiteam.frikievents.socialnetworks.query.projections.comment.CommentHistoryViewRepository;
import com.frikiteam.frikievents.socialnetworks.query.projections.comment.CommentView;
import com.frikiteam.frikievents.socialnetworks.query.projections.comment.CommentViewRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
@Tag(name = "Comments")
public class CommentQueryController {
  private final CommentHistoryViewRepository commentHistoryViewRepository;
  private final CommentViewRepository commentViewRepository;

  public CommentQueryController(CommentHistoryViewRepository commentHistoryViewRepository, CommentViewRepository commentViewRepository) {
    this.commentHistoryViewRepository = commentHistoryViewRepository;
    this.commentViewRepository = commentViewRepository;
  }

  @GetMapping("")
  @Operation(summary = "Get all comments")
  public ResponseEntity<List<CommentView>> getAllComments() {
    try {
      List<CommentView> commentViews = commentViewRepository.findAll();
      return new ResponseEntity(commentViews, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{content}")
  @Operation(summary = "Get comment by content")
  public ResponseEntity<List<CommentView>> getCommentById(@PathVariable() String content) {
    try {
      List<CommentView> commentViews = commentViewRepository.getCommentByCommentId(content);

      return new ResponseEntity(commentViews, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/history/{id}")
  @Operation(summary = "Get comment history")
  public ResponseEntity<List<CommentHistoryView>> getCommentHistoryById(@PathVariable() String id) {
    try {
      List<CommentHistoryView> commentHistoryViews = commentHistoryViewRepository.getCommentHistoryByCommentId(id);
      return new ResponseEntity(commentHistoryViews, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
