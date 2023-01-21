package com.alexandrazbant.SpringDataJPAJDBC.dao;

import com.alexandrazbant.SpringDataJPAJDBC.domain.Author;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AuthorDaoImpl implements AuthorDao{

    private final JdbcTemplate jdbcTemplate;


    @Override
    public Author getById(Long id) {
        return null;
    }

    @Override
    public Author findAuthorByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Author saveNewAuthor(Author author) {
        return null;
    }

    @Override
    public Author updateAuthor(Author author) {
        return null;
    }

    @Override
    public void deleteAuthorById(Long id) {

    }

    private RowMapper<Author> getRowMapper(){
        return new AuthorMapper();
    }
}
