package br.net.galdino.spring6webapp.bootstrap;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.net.galdino.spring6webapp.domain.Author;
import br.net.galdino.spring6webapp.domain.Book;
import br.net.galdino.spring6webapp.domain.Publisher;
import br.net.galdino.spring6webapp.repositories.AuthorRepository;
import br.net.galdino.spring6webapp.repositories.BookRepository;
import br.net.galdino.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");
        eric.setBooks(new HashSet<>());

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");
		ddd.setAuthors(new HashSet<>());

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);
        
        ericSaved.getBooks().add(dddSaved);
        dddSaved.getAuthors().add(ericSaved);

        
        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");
        rod.setBooks(new HashSet<>());

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");
		noEJB.setAuthors(new HashSet<>());

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);
        
        rodSaved.getBooks().add(noEJBSaved);
        noEJBSaved.getAuthors().add(rodSaved);


        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");
        Publisher savedPublisher = publisherRepository.save(publisher);

        dddSaved.setPublisher(savedPublisher);
        noEJBSaved.setPublisher(savedPublisher);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}