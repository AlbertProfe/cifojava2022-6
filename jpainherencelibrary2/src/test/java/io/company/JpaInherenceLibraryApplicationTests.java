package io.company;

import io.company.model.*;
import io.company.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaInherenceLibraryApplicationTests {

	@Autowired
	ItemBookRepository itemBookRepository;
	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	RareBookRepository rareBookRepository;
	@Autowired
	PocketItemBookRepository PocketItemBookRepository;

	@Test
	void createObjects() {
		//save a Book object
		Book book1 = new Book();
		bookRepository.save(book1);
		//just save a itemBook
		ItemBook itemBook1 = new ItemBook();
		itemBookRepository.save(itemBook1);
		//just save a rareBook
		RareBook rareBook1 = new RareBook();
		rareBookRepository.save(rareBook1);
		//just save a itemBook with BOOK reference
		//so in compilation time it is a BOOK
		Book itemBook2 = new ItemBook();
		bookRepository.save(itemBook2);
		//rareBook with BOOK reference
		Book rareBook2 = new RareBook();
		bookRepository.save(rareBook2);

		//let s save an AUTHOR object
		//AUTHOR1
		Author author1 = new Author();
		authorRepository.save(author1);
		//let s join BOOK and AUTHOR
		author1.getBooks().add(book1);
		authorRepository.save(author1);

		//let s save an AUTHOR object
		//AUTHOR2
		Author author2 = new Author();
		authorRepository.save(author2);
		//let s join 2 BOOK and AUTHOR
		author2.getBooks().add(itemBook1);
		author2.getBooks().add(itemBook2);
		authorRepository.save(author2);

		//let s save an AUTHOR object
		//AUTHOR3
		Author author3 = new Author();
		authorRepository.save(author3);
		//let s join a BOOK and AUTHOR
		author3.getBooks().add(itemBook1);
		authorRepository.save(author3);
		//let s join another book
		//author3.getBooks().add(itemBook2);
		//authorRepository.save(author3);

		PocketItemBook pocketItemBook1 = new PocketItemBook();
		PocketItemBookRepository.save(pocketItemBook1);


	}

}
