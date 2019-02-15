package io.spring.aula.lamantovani.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.spring.aula.lamantovani.entity.Usuario;
import io.spring.aula.lamantovani.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> listaUsuario() {
		return usuarioRepository.findAll();
	}

	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario editarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void deletarUsuario(String id) {
		usuarioRepository.delete(id);
	}

	public Usuario consultarUsuario(String id) {
		return usuarioRepository.findOne(id);
	}

	public List<Usuario> buscarPorNome(String nome) {
		return usuarioRepository.findByNomeLikeIgnoreCase(nome);
	}

	public Page<Usuario> listaPagina(int page, int count) {
		Pageable pages = new PageRequest(page, count);
		return usuarioRepository.findAll(pages);
	}
	
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}


}
