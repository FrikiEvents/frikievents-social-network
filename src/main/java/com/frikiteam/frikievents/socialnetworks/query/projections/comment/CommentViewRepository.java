package com.frikiteam.frikievents.socialnetworks.query.projections.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentViewRepository extends JpaRepository<CommentView, String> {

    @Query(value = "SELECT * FROM comment_view WHERE id = :commentId", nativeQuery = true)
    List<CommentView> getCommentByCommentId(String commentId);
}
