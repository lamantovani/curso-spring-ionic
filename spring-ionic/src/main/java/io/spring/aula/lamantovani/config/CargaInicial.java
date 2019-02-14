package io.spring.aula.lamantovani.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import io.spring.aula.lamantovani.entity.Perfil;
import io.spring.aula.lamantovani.entity.Usuario;
import io.spring.aula.lamantovani.repository.PerfilRepository;
import io.spring.aula.lamantovani.repository.UsuarioRepository;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PerfilRepository perfilRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<Perfil> perfis = this.perfilRepository.findAll();
		
		if (perfis.isEmpty()) {
			this.perfilRepository.save(new Perfil("ROLE_ADMIN"));
			
			Perfil perfil = this.perfilRepository.findByNome("ROLE_ADMIN");
			
			List<Perfil> perfisUsuario = new ArrayList<Perfil>();
			perfisUsuario.add(perfil);
			
			this.usuarioRepository.save(new Usuario("Admin", "admin@mail.com", "123", perfisUsuario));
		}
		
	}
	
	

}
