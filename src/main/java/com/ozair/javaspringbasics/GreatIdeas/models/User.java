package com.ozair.javaspringbasics.GreatIdeas.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	@Size(max=55)
	private String email;
	@NotBlank
	@Size(min=8)
	private String password;
	@Transient
	private String passwordValidation;
	@OneToMany(mappedBy="ideauser", cascade = CascadeType.ALL, 	fetch=FetchType.LAZY)
	private List<Ideas> ideasCreated;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			
			name="likes",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name= "idea_id")
			
			)
	
	private List<Ideas> likes;

	public User() {
}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordValidation() {
		return passwordValidation;
	}


	public void setPasswordValidation(String passwordValidation) {
		this.passwordValidation = passwordValidation;
	}


	public List<Ideas> getIdeasCreated() {
		return ideasCreated;
	}


	public void setIdeasCreated(List<Ideas> ideasCreated) {
		this.ideasCreated = ideasCreated;
	}


	public List<Ideas> getLikes() {
		return likes;
	}


	public void setLikes(List<Ideas> likes) {
		this.likes = likes;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


}
