package ua.lviv.lgs.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.AccessLevel;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.dto.CaptchaResponse;
import ua.lviv.lgs.service.UserService;

@Controller

public class RegistrationController {
	private final static String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private RestTemplate restTemplate;

	@Value("${recaptcha.secret}")
    private String secret;
	
	@GetMapping("/registration")
	public String viewRegistrationForm() {
		return "registration";
		
	}
	
	@PostMapping("/registration")
	public String registerUser(@RequestParam("g-recaptcha-response") String reCaptchaResponse, User user, Model model, RedirectAttributes redir) {
		String url = String.format(CAPTCHA_URL, secret, reCaptchaResponse);
        CaptchaResponse captchaResponse = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponse.class);

        if (!captchaResponse.isSuccess()) {
            model.addAttribute("captchaError");
            return "registration";
        }
		if (!userService.addUser(user)) {
			model.addAttribute("message", "Такий користувач вже є!");
			return "registration";
		}
		
		redir.addFlashAttribute("message", "Для активації перейдіть за посилання в листі, відправленому на вказану Вами пошту");
		return "redirect:/login/";
		
	}
	
	@GetMapping("/activate/{code}")
    public String activate(@PathVariable String code, Model model) {
        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            model.addAttribute("message", "Користувача активовано!");
        } else {
            model.addAttribute("message", "Невірний код активації!");
        }

        return "login";
    }

}
