package com.goyal.ekansh.blogapp.repository;

import com.goyal.ekansh.blogapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
