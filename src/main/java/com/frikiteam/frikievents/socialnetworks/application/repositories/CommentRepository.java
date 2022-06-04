package com.frikiteam.frikievents.socialnetworks.application.repositories;

import com.frikiteam.frikievents.socialnetworks.domain.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentRepository<T extends Comment> extends JpaRepository<T, UUID> {
}
