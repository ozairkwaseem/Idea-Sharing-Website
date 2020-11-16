package com.ozair.javaspringbasics.GreatIdeas.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="ideas")
public class Ideas {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String inspiration;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name= "user_id")
	private User ideauser;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			
			name="likes",
			joinColumns = @JoinColumn(name="idea_id"),
			inverseJoinColumns = @JoinColumn(name= "user_id")
			
			)
	private List<User> likers;

//	private List<User> users;

	public Ideas() {
		
	}
	public List<User> getLikers() {
		return likers;
	}
	public void setLikers(List<User> likers) {
		this.likers = likers;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public User getIdeauser() {
		return ideauser;
	}
	public void setIdeauser(User ideauser) {
		this.ideauser = ideauser;
	}
//	public List<User> getUsers() {
//		return users;
//	}
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getinspiration() {
		return inspiration;
	}
	public void setinspiration(String inspiration) {
		this.inspiration = inspiration;
	}

	
}
