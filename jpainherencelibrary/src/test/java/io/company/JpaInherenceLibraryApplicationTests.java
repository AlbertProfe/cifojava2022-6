package io.company;

import io.company.model.Author;
import io.company.model.Book;
import io.company.model.ItemBook;
import io.company.model.RareBook;
import io.company.repository.AuthorRepository;
import io.company.repository.BookRepository;
import io.company.repository.ItemBookRepository;
import io.company.repository.RareBookRepository;
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

	@Test
	void createObjects() {

		ItemBook itemBook1 = new ItemBook();
		itemBookRepository.save(itemBook1);

		Book itemBook2 = new ItemBook();
		bookRepository.save(itemBook2);

		RareBook rareBook1 = new RareBook();
		rareBookRepository.save(rareBook1);

		Book rareBook2 = new RareBook();
		bookRepository.save(rareBook2);

		Book book1 = new Book();
		bookRepository.save(book1);

		Author author1 = new Author();
		authorRepository.save(author1);

		author1.getBooks().add(book1);
		authorRepository.save(author1);

//		author1.getBooks().add(itemBook2);
//		authorRepository.save(author1);












	}

}
