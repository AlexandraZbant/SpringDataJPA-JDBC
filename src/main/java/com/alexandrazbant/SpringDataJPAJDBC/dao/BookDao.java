package com.alexandrazbant.SpringDataJPAJDBC.dao;

import com.alexandrazbant.SpringDataJPAJDBC.domain.Author;
import com.alexandrazbant.SpringDataJPAJDBC.domain.Book;

public interface BookDao {

    Book getById(Long id);

    Book getByTitle(String title);

    Book saveNew(Book book);

    Book update(Book book);

    void deleteById(Long id);

}
