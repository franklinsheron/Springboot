package com.libmngmt.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libmngmt.repository.UserRepository;
import com.libmngmt.model.User;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userrepository;
	
	public User createUser(User user)
	{
		return userrepository.save(user);
	}
	public User updateUser(User user, Long id) {
		User existinguser = userrepository.findById(id).get();
		existinguser.setName(user.getName());
        return userrepository.save(existinguser);
    }

    public void deleteUser(Long id) {
    	User existinguser = userrepository.findById(id).get();
        userrepository.delete(existinguser);
    }

    public List<User> getAllUsers() {
        return userrepository.findAll();
    }

    public User getUserById(Long id) {
        return userrepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
    }

}
