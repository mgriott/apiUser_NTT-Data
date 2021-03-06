package com.apiUser.apiUser.repository;

import com.apiUser.apiUser.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends JpaRepository<Users, Long> {
}
