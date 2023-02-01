package com.prog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entity.Book;
import com.prog.repository.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo repo;
	
	public void registerBook(Book b) {
		repo.save(b);
		return;
	}
	
	public List<Book> bookList() {
		return repo.findAll();
	}
	
	public Book getBookById(int id) {
		Optional<Book> b = repo.findById(id);
		if(b.isPresent())
			return b.get();
		return null;
	}
	
	public void deleteBookById(int id) {
		repo.deleteById(id);
		return;
	}

}
