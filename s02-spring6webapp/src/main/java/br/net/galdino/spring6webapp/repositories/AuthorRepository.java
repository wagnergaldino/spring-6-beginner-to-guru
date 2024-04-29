package br.net.galdino.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import br.net.galdino.spring6webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
