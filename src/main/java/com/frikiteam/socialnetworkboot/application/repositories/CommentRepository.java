package com.frikiteam.socialnetworkboot.application.repositories;

import com.frikiteam.socialnetworkboot.domain.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentRepository<T extends Comment> extends JpaRepository<T, UUID> {
}
