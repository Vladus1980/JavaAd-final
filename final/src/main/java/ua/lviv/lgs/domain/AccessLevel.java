package ua.lviv.lgs.domain;

import org.springframework.security.core.GrantedAuthority;

public enum AccessLevel {
	
	USER, ADMIN;
	
	public String getAuthority() {
		return name();
	}

}
