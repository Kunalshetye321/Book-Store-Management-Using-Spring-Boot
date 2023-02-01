package com.prog.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prog.entity.MyBookList;

@Repository
public interface MyBookRepo extends JpaRepository<MyBookList, Integer>{

}