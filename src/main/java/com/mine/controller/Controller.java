package com.mine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mine.persistence.Book;
import com.mine.service.BookService;


@RestController
public class Controller {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/populate")
	public void populateBookList() {
		bookService.populateBooks();
	}
	
	
	@GetMapping("/Book")
	public List<Book> showBooks(){
		return bookService.retBooks();
	}
	@RequestMapping("/Book/{id}")
	public Book getBook(@PathVariable String id) {
		return bookService.getBookById(id);
		
	}
	@RequestMapping("/Book/search/{keyword}")
	public List<Book> searchBook(@PathVariable String keyword) {
		 return bookService.searchBook(keyword);
	}
	@RequestMapping(method=RequestMethod.POST, value="/Book")
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}
	@RequestMapping(method=RequestMethod.PUT, value= "/Book/update/{id}")
	public void updateBook(@PathVariable String id,@RequestBody Book book) {
		bookService.updateBook(id,book);
	}
	@DeleteMapping("/Book/delete/{id}")
	public void deleteBook(@PathVariable String id) {
		bookService.deleteBook(id);
	}
}

