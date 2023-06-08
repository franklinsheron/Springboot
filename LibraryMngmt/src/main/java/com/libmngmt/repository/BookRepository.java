package com.libmngmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.libmngmt.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long>
{

}
