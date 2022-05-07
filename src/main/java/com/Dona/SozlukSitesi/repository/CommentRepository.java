package com.Dona.SozlukSitesi.repository;

import com.Dona.SozlukSitesi.model.Comment;
import com.Dona.SozlukSitesi.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long userId);

    List<Comment> findByUserId(Long postId);
}
