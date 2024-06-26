package br.net.galdino.spring6webapp.services;

import org.springframework.stereotype.Service;

import br.net.galdino.spring6webapp.domain.Author;
import br.net.galdino.spring6webapp.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
