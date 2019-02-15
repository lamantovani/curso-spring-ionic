package io.spring.aula.lamantovani.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.spring.aula.lamantovani.entity.Usuario;
import io.spring.aula.lamantovani.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public List<Usuario> listUsuario() {
		return this.usuarioService.listaUsuario();
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		return this.usuarioService.salvarUsuario(usuario);
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.PUT)
	public Usuario editarUsuario(@RequestBody Usuario usuario) {
		return this.usuarioService.editarUsuario(usuario);
	}
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	public void deletarUsuario(@PathVariable String id) {
		this.usuarioService.deletarUsuario(id);
	}
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public Usuario consultarUsuario(@PathVariable String id) {
		return this.usuarioService.consultarUsuario(id);
	}
	
	@RequestMapping(value = "/usuario/{page}/{count}", method = RequestMethod.GET)
	public Page<Usuario> listaPagina(@PathVariable int page, @PathVariable int count) {
		return this.usuarioService.listaPagina(page, count);
	}
	
	@RequestMapping(value = "/usuario/{nome}/nome", method = RequestMethod.GET)
	public List<Usuario> buscarPorNome(@PathVariable String nome) {
		return this.usuarioService.buscarPorNome(nome);
	}
	
	@RequestMapping(value = "/usuario/logado", method = RequestMethod.GET)
	@ResponseBody
	public Usuario currentUserName(Principal principal) {
		Usuario usuario =  this.usuarioService.findByEmail(principal.getName());
		usuario.setSenha("");
		return usuario;
	}

}
