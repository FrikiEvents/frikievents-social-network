package com.frikiteam.frikievents.socialnetworks.query.projections.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentHistoryViewRepository extends JpaRepository<CommentHistoryView, Long> {
  @Query(value = "SELECT * FROM comment_history_view WHERE comment_history_id = (SELECT MAX(comment_history_id) FROM comment_history_view WHERE comment_id = :commentId)", nativeQuery = true)
  Optional<CommentHistoryView> getLastCommentHistoryByCommentId(String commentId);

  @Query(value = "SELECT * FROM comment_history_view WHERE comment_id = :commentId", nativeQuery = true)
  List<CommentHistoryView> getCommentHistoryByCommentId(String commentId);
}
