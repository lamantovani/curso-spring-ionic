package io.spring.aula.lamantovani.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.spring.aula.lamantovani.entity.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String> {

	List<Perfil> findByNomeLikeIgnoreCase();

	Perfil findByNome(String nome);

}
