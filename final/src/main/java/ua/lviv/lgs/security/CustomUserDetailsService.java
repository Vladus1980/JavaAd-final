package ua.lviv.lgs.security;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.AccessLevelRepository;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.User;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AccessLevelRepository accessLevelRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		
		Optional<User> userOptional = userRepository.findByEmail(email);
		if(userOptional.isPresent()) {
			List<String> accessLevel = accessLevelRepository.findRolesByUserName(email);
			return new CustomUserDetails(userOptional.get(), accessLevel);
		}
		throw new NotFoundException("Немає користувача з логіном: "+ email);
	}

	
}
