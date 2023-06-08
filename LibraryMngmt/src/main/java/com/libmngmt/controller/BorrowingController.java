package com.libmngmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.libmngmt.model.Borrowing;
import com.libmngmt.service.BorrowingService;

@RestController
@RequestMapping("/borrows")
public class BorrowingController
{
	
	@Autowired
	private BorrowingService borrowingservice;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Borrowing create(@RequestBody Borrowing borrow)
	{
		return borrowingservice.createBorrow(borrow);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Borrowing> read()
	{
		return borrowingservice.getAllBorrows();
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		borrowingservice.deleteborrow(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public Borrowing update(@PathVariable Long id, @RequestBody Borrowing borrow) {
		return borrowingservice.updateBorrow(borrow, id);
	}

}
