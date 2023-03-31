package com.alipour.rest.webservices.restfulwebservices.repository;

import com.alipour.rest.webservices.restfulwebservices.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Paniz Alipour
 */
public interface PostRepository extends JpaRepository<Post, Integer> {
}
