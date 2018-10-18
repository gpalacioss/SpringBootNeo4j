package com.practica.primerEjemplo.service.user.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practica.primerEjemplo.models.user.User;
import com.practica.primerEjemplo.repository.user.UserRepository;
import com.practica.primerEjemplo.service.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User usuario = userRepository.findByUsername(username);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Nombre de usuario invalido");
		}
		
		//return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(), getAuthority(usuario.getRoles()));
		
		usuario.setAuthorities("ROLE_USER, ROLE_ADMIN");
		
		return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(usuario.getAuthorities()));
		
	}

}
