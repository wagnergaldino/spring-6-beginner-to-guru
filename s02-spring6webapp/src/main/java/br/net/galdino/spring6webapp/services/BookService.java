package br.net.galdino.spring6webapp.services;

import br.net.galdino.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
