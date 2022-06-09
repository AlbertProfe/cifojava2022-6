package io.company;

import io.company.model.*;
import io.company.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

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
		book1.setTitle("Anna Karenina");
		book1.setPages(456);
		book1.setPublishedYear(1886);
		book1.setIsbn("EWTEGRETG456RG45DF");
		bookRepository.save(book1);//just save a itemBook

		ItemBook itemBook1 = new ItemBook();
		itemBook1.setTitle("To the lighthouse");
		itemBook1.setPages(235);
		itemBook1.setPublishedYear(1926);
		itemBook1.setIsbn("BVNY879H5ERW45TWG");
		//status enum
		Status status = Status.BORROWED;
		itemBook1.setStatus(status);
		LocalDate borrowddate = LocalDate.of(2022, 2, 22);
		LocalDate duedate = LocalDate.of(202, 3, 6);
		itemBook1.setBorrowedDate(borrowddate);
		itemBook1.setDueDate(duedate);
		itemBook1.setLoanPeriod(15);
		itemBook1.setOverDueDaysQty(5);
		itemBookRepository.save(itemBook1);

		//just save a rareBook
		RareBook rareBook1 = new RareBook();
		rareBook1.setTitle("I love Java");
		rareBook1.setIsbn("BVNTRYDNTR57DHGFR");
		rareBook1.setPages(356);
		rareBook1.setPublishedYear(1436);
		rareBook1.setCollection(true);
		rareBook1.setHandMade(true);
		rareBook1.setHandNumbered(true);
		rareBook1.setNumberCollection("45645-EVIL");
		rareBookRepository.save(rareBook1);

		//just save a itemBook with BOOK reference
		//so in compilation time it is a BOOK
		Status status2 = Status.HOME;
		LocalDate borrowddate2 = LocalDate.of(2022, 2, 22);
		LocalDate duedate2 = LocalDate.of(2022, 3, 6);
		Book itemBook2 = new ItemBook("Orlando",535, 1932, "BVEW657HTR6Y5W45TWG", status2, borrowddate2, duedate2, 15, 1);
		itemBook2.setTitle("Orlando");
		itemBook2.setPages(535);
		itemBook2.setPublishedYear(1932);
		itemBook2.setIsbn("BVEW657HTR6Y5W45TWG");
		//itemBook2.setStatus(Status.HOME);
		//itemBook2.setBorrowedDate(borrowddate2);
		//itemBook2.setDueDate(duedate2);
		//itemBook2.setLoanPeriod(15);
		//itemBook2.setOverDueDaysQty(1);
		bookRepository.save(itemBook2);
		//rareBook with BOOK reference
		Book rareBook2 = new RareBook();
		rareBook2.setTitle("I love JS");
		rareBook2.setIsbn("3434ERGG5WGFGFR");
		rareBook2.setPages(312);
		rareBook2.setPublishedYear(1437);
		//rareBook2.setCollection(false);
		//rareBook2.setHandMade(true);
		//rareBook2.setHandNumbered(true);
		//rareBook2.setNumberCollection("45641-EVIL");
		bookRepository.save(rareBook2);

		//let s save an AUTHOR object
		//AUTHOR1
		Author author1 = new Author();
		author1.setFirstName("Leon");
		author1.setLastName("Tolstoi");
		LocalDate dob = LocalDate.of(1856, 3, 12);
		author1.setDob(dob);
		authorRepository.save(author1);
		//let s join BOOK and AUTHOR
		author1.getBooks().add(book1);
		authorRepository.save(author1);

		//let s save an AUTHOR object
		//AUTHOR2
		Author author2 = new Author();
		author2.setFirstName("Virginia");
		author2.setLastName("Wolf");
		LocalDate dob2 = LocalDate.of(1993, 12, 5);
		author2.setDob(dob2);
		authorRepository.save(author2);
		//let s join 2 BOOK and AUTHOR
		author2.getBooks().add(itemBook1);
		author2.getBooks().add(itemBook2);
		authorRepository.save(author2);

		//let s save an AUTHOR object
		//AUTHOR3
		Author author3 = new Author();
		authorRepository.save(author3);
		author3.setFirstName("Leonard");
		author3.setLastName("Wolf");
		LocalDate dob3 = LocalDate.of(1993, 12, 5);
		author3.setDob(dob3);
		//let s join a BOOK and AUTHOR
		author3.getBooks().add(itemBook1);
		//authorRepository.save(author3);
		//let s join another book
		//author3.getBooks().add(itemBook2);
		//authorRepository.save(author3);

		PocketItemBook pocketItemBook1 = new PocketItemBook();
		pocketItemBook1.setTitle("A room on my own");
		pocketItemBook1.setPages(135);
		pocketItemBook1.setPublishedYear(1935);
		pocketItemBook1.setIsbn("B45G5GHE5Y454RHG5");
		Status status3 = Status.DELAY;
		pocketItemBook1.setStatus(status3);
		LocalDate borrowddate3 = LocalDate.of(2022, 2, 22);
		LocalDate duedate3 = LocalDate.of(202, 3, 6);
		pocketItemBook1.setBorrowedDate(borrowddate3);
		pocketItemBook1.setDueDate(duedate3);
		pocketItemBook1.setLoanPeriod(20);
		pocketItemBook1.setOverDueDaysQty(-1);
		pocketItemBook1.setSize("BigPocket");
		PocketItemBookRepository.save(pocketItemBook1);
		author3.getBooks().add(pocketItemBook1);
		authorRepository.save(author3);


	}

}
