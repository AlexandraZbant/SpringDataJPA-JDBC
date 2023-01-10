package com.alexandrazbant.SpringDataJPAJDBC.dao;

import com.alexandrazbant.SpringDataJPAJDBC.domain.Author;

public interface AuthorDao {

    Author getId(Long id);

    Author getByName(String firstName, String lastName);

    Author saveNew(Author author);
}
