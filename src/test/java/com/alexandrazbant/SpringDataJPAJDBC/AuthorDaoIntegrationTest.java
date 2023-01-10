package com.alexandrazbant.SpringDataJPAJDBC;

import com.alexandrazbant.SpringDataJPAJDBC.dao.AuthorDao;
import com.alexandrazbant.SpringDataJPAJDBC.domain.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

    /*
    @Import(AuthorDaoImpl.class)
    when the test fails in intelij because the assertion is incorrect
    but in maven fails because the entity is not autowired properly,
    because @ComponentScan is not bringing the entity in the context of spring
    */


@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"com.alexandrazbant.SpringDataJPAJDBC.dao;"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthorDaoIntegrationTest {

    @Autowired
    AuthorDao authorDao;

    @Test
    void testGetAuthor() {
        Author author = authorDao.getId(1L);
        assertThat(author).isNotNull();
    }

    @Test
    void testGetAuthorByName() {
        Author author = authorDao.getByName("Craig", "Walls");
        assertThat(author).isNotNull();
    }
}
