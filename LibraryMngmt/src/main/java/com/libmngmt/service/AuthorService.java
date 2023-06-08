package com.libmngmt.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libmngmt.model.Author;
import com.libmngmt.repository.AuthorRepository;

@Service
public class AuthorService
{
	@Autowired
	private AuthorRepository authorrepository;
	
	public Author createAuthor(Author author)
	{
		return authorrepository.save(author);
	}
	public Author updateAuthor(Author author, Long id) {
		Author existingauthor = authorrepository.findById(id).get();
		existingauthor.setName(author.getName());
        return authorrepository.save(existingauthor);
    }

    public void deleteAuthor(Long id) {
    	Author existingauthor = authorrepository.findById(id).get();
        authorrepository.delete(existingauthor);
    }

    public List<Author> getAllAuthors() {
        return authorrepository.findAll();
    }

    public Author getAuthorsById(Long id) {
        return authorrepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Author not found with id: " + id));
    }
}
