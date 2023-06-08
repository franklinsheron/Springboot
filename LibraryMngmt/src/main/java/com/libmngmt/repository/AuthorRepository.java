package com.libmngmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libmngmt.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>
{

}
