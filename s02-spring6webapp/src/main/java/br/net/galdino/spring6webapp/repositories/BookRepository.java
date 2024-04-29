package br.net.galdino.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import br.net.galdino.spring6webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
