package br.net.galdino.spring6webapp.services;

import br.net.galdino.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
