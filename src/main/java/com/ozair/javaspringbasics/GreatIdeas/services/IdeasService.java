package com.ozair.javaspringbasics.GreatIdeas.services;

import java.security.acl.Owner;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozair.javaspringbasics.GreatIdeas.models.Ideas;
import com.ozair.javaspringbasics.GreatIdeas.models.User;
import com.ozair.javaspringbasics.GreatIdeas.repositories.IdeasRepository;
import com.ozair.javaspringbasics.GreatIdeas.repositories.UserRepository;

@Service
public class IdeasService {

	@Autowired
	private IdeasRepository iRepo;
	@Autowired 
	private UserRepository uRepo;
	
	
	public List<Ideas> getIdeas(){
		return this.iRepo.findAll();
	}


	public Ideas findIdeaById(Long id) {
		return this.iRepo.findById(id).orElse(null);
	}
	
//	public Ideas findUserIdofCreator(long userIdOfCreator) {
//		return this.iRepofind
//	}
	public Ideas create(Ideas idea) {
		return this.iRepo.save(idea);
	}
	public Ideas update(Ideas idea) {
		return this.iRepo.save(idea);
	}
	public void delete(Long id) {
		this.iRepo.deleteById(id);
	}
	

	public void addLiker(User user, Ideas idea) {
		List<User> likers = idea.getLikers();
		likers.add(user);
		this.iRepo.save(idea);
	}
	
	public void removeLiker(User user, Ideas idea) {
		List<User> likers = idea.getLikers();
		likers.remove(user);
		this.iRepo.save(idea);
	}

	
}

