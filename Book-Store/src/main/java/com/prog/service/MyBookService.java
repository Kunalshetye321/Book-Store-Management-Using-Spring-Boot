package com.prog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entity.MyBookList;
import com.prog.repository.MyBookRepo;

@Service
public class MyBookService {

	@Autowired
	private MyBookRepo repo;
	
	public void saveMyBook(MyBookList book) {
		repo.save(book);
	}
	
	public List<MyBookList> bookList() {
		return repo.findAll();
	}
	
	
	public void deleteBookById(int id) {
		repo.deleteById(id);
		return;
	}
}
