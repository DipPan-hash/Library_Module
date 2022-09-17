package com.module.library.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.module.library.dto.UserDTO;
import com.module.library.entities.User;
import com.module.library.repository.UserRepository;
import com.module.library.util.ApplicationUtil;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		return new UserDetailsImpl(ApplicationUtil.map(user, UserDTO.class));
	}

}
