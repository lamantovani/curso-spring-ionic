package io.spring.aula.lamantovani.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.spring.aula.lamantovani.config.MyUserDetails;
import io.spring.aula.lamantovani.entity.Usuario;
import io.spring.aula.lamantovani.repository.UsuarioRepository;

@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário ou senha inválido");
		}
		
		return new MyUserDetails(usuario);
	}

}
