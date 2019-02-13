package io.spring.aula.lamantovani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spring.aula.lamantovani.entity.Perfil;
import io.spring.aula.lamantovani.service.PerfilService;

@RestController
public class PerfilController {
	
	@Autowired
	PerfilService perfilService;
	
	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public List<Perfil> listarPerfil() {
		return this.perfilService.listarPerfil();
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.POST)
	public Perfil salvar(@RequestBody Perfil perfil) {
		return this.perfilService.salvarPerfil(perfil);
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.PUT)
	public Perfil editar(@RequestBody Perfil perfil) {
		return this.perfilService.editarPerfil(perfil);
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable String id) {
		this.perfilService.deletarPerfil(id);
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
	public Perfil consultar(@PathVariable String id) {
		return this.perfilService.consultarPerfil(id);
	}
	
	@RequestMapping(value = "/perfil/{page}/{size}", method = RequestMethod.GET)
	public Page<Perfil> listaPagina(@PathVariable int page, @PathVariable int size) {
		return this.perfilService.listaPaginada(page, size);
	}
	
	@RequestMapping(value = "/perfil/{nome}/nome", method = RequestMethod.GET)
	public List<Perfil> buscarPorNome(@PathVariable String nome) {
		return this.perfilService.buscarPorNome(nome);
	}

}
