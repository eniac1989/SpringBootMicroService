package com.alipour.rest.webservices.restfulwebservices.repository;

import com.alipour.rest.webservices.restfulwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Paniz Alipour
 */

public interface UserRepository extends JpaRepository<User, Integer> {
}
