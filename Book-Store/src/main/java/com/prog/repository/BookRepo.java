package com.prog.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prog.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{

}
