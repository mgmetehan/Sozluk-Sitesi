package com.Dona.SozlukSitesi.repository;

import com.Dona.SozlukSitesi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

}
