package ua.lviv.lgs.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ua.lviv.lgs.dao.AccessLevelRepository;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.User;

public class CustomUserDetailsService implements UserDetailsService{
	
	private UserRepository userRepository;
	private AccessLevelRepository accessLevelRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return null;
	}

	
}
