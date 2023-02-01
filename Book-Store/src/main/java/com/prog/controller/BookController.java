package com.prog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.prog.entity.Book;
import com.prog.entity.MyBookList;
import com.prog.service.BookService;
import com.prog.service.MyBookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookService myservice;

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		
		return "bookRegister";
	}
	
	@GetMapping("/available_book")
	public String availableBook(Model m) {
		List<Book> book = service.bookList();
		m.addAttribute("book", book);
		return "availableBook";
	}
	
	@PostMapping("/register")
	public String registerBook(@ModelAttribute Book b) {
		service.registerBook(b);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Book book = service.getBookById(id);
		m.addAttribute("book", book);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateBook(@ModelAttribute Book b) {
		service.registerBook(b);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		service.deleteBookById(id);
		return "redirect:/available_book";
	
	}
	
	@GetMapping("/myBook") 
	public String myBookCollection(Model m){
		List<MyBookList> mybook = myservice.bookList();
		m.addAttribute("mybook", mybook);
		return "myBook";
	}
	
	@RequestMapping("/myBookCollectoin/{id}")
	public String myBookCollectionSave(@PathVariable int id) {
		Book b = service.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myservice.saveMyBook(mb);
		return "redirect:/available_book";
	}

	@GetMapping("/mydelete/{id}")
	public String myBookdelete(@PathVariable int id) {
		myservice.deleteBookById(id);
		return "redirect:/myBook";
	
	}
}
