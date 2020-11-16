package com.ozair.javaspringbasics.GreatIdeas.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozair.javaspringbasics.GreatIdeas.models.User;
import com.ozair.javaspringbasics.GreatIdeas.repositories.IdeasRepository;
import com.ozair.javaspringbasics.GreatIdeas.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private IdeasRepository iRepo;
	@Autowired 
	private UserRepository uRepo;
		
	public List<User> allUsers(){
		return this.uRepo.findAll();
	}
	public User findById(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	
	
	public User getuserByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
//	Login

	public User userRegistration(User newUser) {
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return this.uRepo.save(newUser);
	}
	public boolean authenticateUser(String email, String password) {
		User user = this.uRepo.findByEmail(email);
		if(user == null)
			return false;
		return BCrypt.checkpw(password, user.getPassword());
	}
}
