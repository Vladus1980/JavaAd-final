package ua.lviv.lgs.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.AccessLevel;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;

@Controller
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("{user}")
	public String userList(Model model) {
		model.addAttribute("users", userService.findAll());
		
		return "userList";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("{user}")
	public String userEditForm(@PathVariable User user, Model model) {
		model.addAttribute("user", user);
		model.addAttribute("accessLevels", AccessLevel.values());
		return "userEditor";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	public String userSave(@RequestParam Map<String, String> form, @RequestParam("userId") User user) {
		
		userService.saveUser(user, form);
		
		return "redirect:/user";
	}
	@GetMapping("profile")
	public String getProfile(@AuthenticationPrincipal User user, Model model) {
		model.addAttribute("user", userService.findById(user.getId()));

		return "profile";
	}
	
	@PostMapping("profile")
	public String updateProfile(@AuthenticationPrincipal User user, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam String password) {
		userService.updateProfile(user, firstName, lastName, email, password);

		
		return "redirect:/user/profile";
	
	
	
	}

}
