package io.spring.aula.lamantovani.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.spring.aula.lamantovani.entity.Perfil;
import io.spring.aula.lamantovani.entity.Usuario;
import io.spring.aula.lamantovani.repository.PerfilRepository;

@Service
public class PerfilService {
	
	@Autowired
	PerfilRepository perfilRepository;
	
	public List<Perfil> listarPerfil() {
		return perfilRepository.findAll();
	}
	
	public Page<Perfil> listaPaginada(int page, int size) {
		Pageable pages = new PageRequest(page, size);
		return perfilRepository.findAll(pages);
	}

	public Perfil salvarPerfil(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	public Perfil editarPerfil(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	public void deletarPerfil(String id) {
		this.perfilRepository.delete(id);
	}

	public Perfil consultarPerfil(String id) {
		return this.perfilRepository.findOne(id);
	}

	public List<Perfil> buscarPorNome(String nome) {
		return this.perfilRepository.findByNomeLikeIgnoreCase();
	}
	
	

}
