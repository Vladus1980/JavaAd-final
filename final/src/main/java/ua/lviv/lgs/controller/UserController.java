package ua.lviv.lgs.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("{user}")
	public String userList(Model model) {
		model.addAttribute("users", userRepository.findAll());
		
		return "userList";
	}
	
	public String userSave(@RequestParam Map<String, String> form, @RequestParam("userId") User user) {
		user.setFirstName(form.get("firstName"));
		user.setLastName(form.get("lastName"));
		user.setEmail(form.get("email"));
		
		if (form.keySet().contains("active")) {
			user.setActive(true);
		} else {
			user.setActive(false);
		}

		user.getAccessLevels().clear();

		Set<String> accessLevels = Arrays.stream(AccessLevel.values()).map(AccessLevel::name).collect(Collectors.toSet());

		for (String key : form.keySet()) {
			if (accessLevels.contains(key)) {
				user.getAccessLevels().add(AccessLevel.valueOf(key));
			}
		}

		userRepository.save(user);

		return "redirect:/user";
	}

}
