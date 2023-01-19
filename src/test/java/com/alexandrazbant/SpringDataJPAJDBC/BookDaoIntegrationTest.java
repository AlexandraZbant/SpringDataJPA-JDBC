package com.alexandrazbant.SpringDataJPAJDBC;

import com.alexandrazbant.SpringDataJPAJDBC.dao.AuthorDao;
import com.alexandrazbant.SpringDataJPAJDBC.dao.BookDao;
import com.alexandrazbant.SpringDataJPAJDBC.domain.Author;
import com.alexandrazbant.SpringDataJPAJDBC.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"com.alexandrazbant.SpringDataJPAJDBC.dao;"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookDaoIntegrationTest {

    @Autowired
    BookDao bookDao;

    @Test
    void testGetBookById() {
        Book book = bookDao.getById(1L);
        assertThat(book).isNotNull();
    }

    @Test
    void testGetBookByTitle() {
        Book book = bookDao.getByTitle("Spring in Action, 5th Edition");
        assertThat(book).isNotNull();
    }

    @Test
    void testSaveNewBook(){
        Book book = new Book();
        book.setTitle("DDD");
        book.setIsbn("123365");
        book.setPublisher("DAO");
        book.setAuthorId(2L);
        Book savedBook = bookDao.saveNew(book);

        assertThat(savedBook).isNotNull();
    }

    @Test
    void testUpdateAuthor(){
        Book book = new Book();
        book.setTitle("blablabla");
        book.setIsbn("123365");
        book.setPublisher("DAO");
        book.setAuthorId(2L);
        Book savedBook = bookDao.saveNew(book);

        savedBook.setTitle("DDD");
        Book updatedBook = bookDao.update(savedBook);

        assertThat(updatedBook.getTitle()).isEqualTo("DDD");
    }

    @Test
    void testDeleteAuthor(){
        Book book = new Book();
        book.setTitle("blablabla");
        book.setIsbn("123365");
        book.setPublisher("DAO");
        book.setAuthorId(2L);
        Book savedBook = bookDao.saveNew(book);
        bookDao.deleteById(savedBook.getId());
        Book deletedBook = bookDao.getById(savedBook.getId());

        assertThat(deletedBook).isNull();
    }
}
