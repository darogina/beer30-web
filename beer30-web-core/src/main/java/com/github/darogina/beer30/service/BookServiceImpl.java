package com.github.darogina.beer30.service;

import com.github.darogina.beer30.entity.BookEntity;
import com.github.darogina.beer30.repository.BookRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named("bookService")
public class BookServiceImpl extends AbstractCrudService<BookEntity, Long, BookRepository> implements BookService {

    @Override @Inject
    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }
}
