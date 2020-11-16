package com.ozair.javaspringbasics.GreatIdeas.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ozair.javaspringbasics.GreatIdeas.models.Ideas;
import com.ozair.javaspringbasics.GreatIdeas.models.User;
import com.ozair.javaspringbasics.GreatIdeas.repositories.IdeasRepository;
import com.ozair.javaspringbasics.GreatIdeas.repositories.UserRepository;
import com.ozair.javaspringbasics.GreatIdeas.services.IdeasService;
import com.ozair.javaspringbasics.GreatIdeas.services.UserService;


@Controller
@RequestMapping("/ideaspage")
public class IdeasController {
	@Autowired
	private IdeasRepository iRepo;
	@Autowired 
	private UserRepository uRepo;
	@Autowired
	private IdeasService iService;
	@Autowired
	private UserService uService;
	
	
	@GetMapping("")
	public String home(@ModelAttribute("ideas") Ideas idea, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userid");
		
		model.addAttribute("userId", userId);
		if(userId == null) {

			return "redirect:/";}
//		List <Ideas> ideaName = this.iService.getIdeas("ideaName");
//		User user = this.uService.findById(userId);
//		Ideas creator = this.iService.getIdeas();
//		model.addAttribute("name", this.iService.getIdeas());
//		model.addAttribute("creator", this.iService.getIdeas());
//		model.addAttribute("user", this.iService.);
		model.addAttribute("user", this.uService.findById(userId));
//		System.out.println("HELLOOO");
		model.addAttribute("ideas", this.iService.getIdeas());
//		model.addAttribute("ideas", this.iService.findIdeaById(userId));
		
		return "/ideas/home.jsp";
	}
	
	@GetMapping ("/createideaselected")
	public String createIdeaButton(@ModelAttribute("idea") Ideas idea, Model model,HttpSession session ) {
		Long userId = (Long)session.getAttribute("userid");
		model.addAttribute("userId", userId);
		User user = this.uService.findById(userId);
		model.addAttribute("user", user);
		return "/ideas/newidea.jsp";
	}
	
	@PostMapping("/createidea")
	public String createIdea(@Valid @ModelAttribute("idea") Ideas idea, BindingResult result, Model model, HttpSession session)
	{ if(result.hasErrors()) {
		Long userId = (Long)session.getAttribute("userid");
		model.addAttribute("userId", userId);
		User user = this.uService.findById(userId);
		model.addAttribute("user", user);
		return "/ideas/newidea.jsp";
	}
	this.iService.create(idea);
	return"redirect:/ideaspage";
		
	}
	public Long userSessionId(HttpSession session) {
		if(session.getAttribute("user") == null)
			return null;
		return (Long)session.getAttribute("user");
	}
	


	@GetMapping("/{id}")
	public String viewIdea(@PathVariable("id")Long id, HttpSession session,Model model) {
//		System.out.println("SHOWWWW");

		Long userId = this.userSessionId(session);
		Ideas idea = this.iService.findIdeaById(id);
		model.addAttribute("ideas", idea);
		return "/ideas/showidea.jsp";
	
	}
	@GetMapping("/{id}/editselected")
	
	public String editIdea(@PathVariable("id")Long id, HttpSession session,Model model) {
//		System.out.println("SHOWWWW");
		Long userId = this.userSessionId(session);
		Ideas idea = this.iService.findIdeaById(id);
		model.addAttribute("ideas", idea);
		return "/ideas/editidea.jsp";
	
	}
	
	@GetMapping("/like/{id}")
	private String like(@PathVariable("id") Long id, HttpSession session){
		Long userId = (Long)session.getAttribute("userid");
		
		Long ideaId = id;
		System.out.println("LIKEEEE BROOO");
		User liker = this.uService.findById(userId);
		
		Ideas likedIdea = this.iService.findIdeaById(ideaId);
		this.iService.addLiker(liker, likedIdea);
		return "redirect:/ideaspage";
	}
	
	@GetMapping("/unlike/{id}")
	private String unlike(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("userid");
		Long ideaId = id;
		User disLiker = this.uService.findById(userId);
		Ideas unLikedIdea = this.iService.findIdeaById(ideaId);
		this.iService.removeLiker(disLiker, unLikedIdea);
		return "redirect:/ideaspage";
	}
	
	@GetMapping("/{id}/edit")
	public String updateIdea(@PathVariable("id")Long id, Ideas idea)
	{ 
		//model.addAttribute("ideas", idea);
		Ideas idea1 = this.iService.findIdeaById(id);
		idea1.setName(idea.getName());
		this.iService.update(idea1);
		
		return "redirect:/ideaspage ";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteIdea(@PathVariable("id")Long id) {
//		System.out.println("delete!!1");
		this.iService.delete(id);
		return "redirect:/ideaspage ";
	}

	
	
}