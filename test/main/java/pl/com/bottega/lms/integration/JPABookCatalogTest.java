package pl.com.bottega.lms.integration;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.com.bottega.lms.application.BookQuery;
import pl.com.bottega.lms.application.BookSearchResults;
import pl.com.bottega.lms.infrastructure.JPABookCatalog;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JPABookCatalogTest {

	@Autowired
	private JPABookCatalog catalog;

	@Test
	@Sql("/fixtures/bookByPhrase.sql")
	@Transactional
	public void shouldFindBookByPhrase() {
		//when
		BookQuery bookQuery = new BookQuery();
		bookQuery.setPhrase("Java");
		BookSearchResults bookSearchResults = catalog.find(bookQuery);

		//then
		assertThat(bookSearchResults.getBooks().size()).isEqualTo(2);
	}

}
