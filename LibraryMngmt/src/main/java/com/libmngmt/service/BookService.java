package com.libmngmt.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libmngmt.model.Book;
import com.libmngmt.repository.BookRepository;
@Service
public class BookService 
{
	@Autowired
	private BookRepository bookrepository;
	
	public Book createBook(Book book)
	{
		return bookrepository.save(book);
	}
	public Book updateBook(Book book, Long id) {
		Book existingbook = bookrepository.findById(id).get();
		existingbook.setTitle(book.getTitle());
		existingbook.setAuthor(book.getAuthor());
		existingbook.setCategory(book.getCategory());
        return bookrepository.save(existingbook);
    }

    public void deleteBook(Long id) {
    	Book existingbook = bookrepository.findById(id).get();
        bookrepository.delete(existingbook);
    }

    public List<Book> getAllBooks() {
        return bookrepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookrepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found with id: " + id));
    }
}
