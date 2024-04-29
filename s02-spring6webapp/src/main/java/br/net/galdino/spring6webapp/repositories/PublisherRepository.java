package br.net.galdino.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import br.net.galdino.spring6webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
