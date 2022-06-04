package com.frikiteam.frikievents.socialnetworks.query.projections.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentViewRepository extends JpaRepository<CommentView, String> {
}
