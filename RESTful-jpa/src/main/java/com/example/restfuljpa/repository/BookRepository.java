package com.example.restfuljpa.repository;

import com.example.restfuljpa.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findBookByAuthorContaining(@Param("author") String author);
}
