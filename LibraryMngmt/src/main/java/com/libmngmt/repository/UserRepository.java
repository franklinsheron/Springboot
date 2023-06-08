package com.libmngmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libmngmt.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

}
