package com.ozair.javaspringbasics.GreatIdeas.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ozair.javaspringbasics.GreatIdeas.models.User;
import com.ozair.javaspringbasics.GreatIdeas.repositories.IdeasRepository;
import com.ozair.javaspringbasics.GreatIdeas.repositories.UserRepository;
import com.ozair.javaspringbasics.GreatIdeas.services.IdeasService;
import com.ozair.javaspringbasics.GreatIdeas.services.UserService;
import com.ozair.javaspringbasics.GreatIdeas.validations.UserValidation;

@Controller
public class UserController {

	@Autowired
	private IdeasRepository iRepo;
	@Autowired 
	private UserRepository uRepo;
	@Autowired
	private IdeasService iService;
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidation userValidator;
	
	@GetMapping("/")
	public String index(@ModelAttribute("registration") User user, Model model) {
		return"/users/loginpage.jsp";
	}
	@PostMapping("/")
	public String register(@Valid @ModelAttribute("registration") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors())
			return "/users/loginpage.jsp";
		User newUser = this.uService.userRegistration(user);
		session.setAttribute("userid", newUser.getId());
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email")String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirect) {
		if(this.uService.authenticateUser(email, password)) {
			User user = this.uService.getuserByEmail(email);
			session.setAttribute("userid", user.getId());
//			System.out.println(session.getAttribute("userid"));
			return "redirect:/ideaspage";
		}
		redirect.addFlashAttribute("error", "Invalid Email or Password!");
		return "redirect:/";
	}
	
}