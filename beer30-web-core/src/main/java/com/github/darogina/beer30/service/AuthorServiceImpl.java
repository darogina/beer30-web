package com.github.darogina.beer30.service;

import com.github.darogina.beer30.entity.AuthorEntity;
import com.github.darogina.beer30.repository.AuthorRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named("authorService")
public class AuthorServiceImpl extends AbstractCrudService<AuthorEntity, Long, AuthorRepository> implements AuthorService {

    @Override @Inject
    public void setRepository(AuthorRepository repository) {
        this.repository = repository;
    }
}
