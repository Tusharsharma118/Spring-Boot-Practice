package com.mine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mine.persistence.Book;

@Service
public class BookService {

	private List<Book> bookList = new ArrayList<Book>();
		
	public List<Book> retBooks(){
		return bookList;
	} 
	public void populateBooks() {
		bookList.add(new Book("1","Inferno","Dan Brown"));
		bookList.add(new Book("2","Angels & Demons","Dan Brown"));
		bookList.add(new Book("3","Origin","Dan Brown"));
		bookList.add(new Book("4","Deception Point","Dan Brown"));

	}
	public Book getBookById(String id) {
	/*	for(Book book:bookList){
			if(book.getId().equals(id)) {
				return book.toString();
			}
		}*/
	return bookList.stream().filter(book-> book.getId().equalsIgnoreCase(id)).findFirst().get();	
	}
	public List<Book> searchBook(String keyword) {
//		List<Book> resultList = new ArrayList<>();
		Stream<Book> bookStream = bookList.parallelStream().filter(book -> book.giveKeywords().toUpperCase().contains(keyword.toUpperCase()));
/*		for(Book book:bookList) {
			if(book.giveKeywords().toUpperCase().contains(keyword.toUpperCase())) {
				resultList.add(book);
			}
		}
		return resultList;
*/
		return bookStream.collect(Collectors.toList());
	}
	
	public boolean addBook(Book book) {
		if(bookList.add(book))
		return true;
		else return false;
	}
	public void updateBook(String id, Book book) {
		int pos=-1;
		for(Book b : bookList) {
			pos++;
			if(b.getId().equalsIgnoreCase(id))
				bookList.set(pos, book);
		}
	}
	public void deleteBook(String id) {
		bookList.removeIf(b->b.getId().equalsIgnoreCase(id));
	}
}
