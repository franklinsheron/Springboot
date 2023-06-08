package com.libmngmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libmngmt.model.Borrowing;
import com.libmngmt.repository.BorrowingRepository;

@Service
public class BorrowingService 
{
	@Autowired
	private BorrowingRepository borrowingrepository;
	
	public Borrowing createBorrow(Borrowing borrow)
	{
		return borrowingrepository.save(borrow);
	}
	public Borrowing updateBorrow(Borrowing borrow, Long id) {
		Borrowing existingborrow = borrowingrepository.findById(id).get();
		existingborrow.setBook(borrow.getBook());
		existingborrow.setUser(borrow.getUser());
		existingborrow.setBorrowDate(borrow.getBorrowDate());
		existingborrow.setReturnDate(borrow.getReturnDate());
        return borrowingrepository.save(existingborrow);
    }

    public void deleteborrow(Long id) {
    	Borrowing existingborrow = borrowingrepository.findById(id).get();
        borrowingrepository.delete(existingborrow);
    }

    public List<Borrowing> getAllBorrows() {
        return borrowingrepository.findAll();
    }
}
