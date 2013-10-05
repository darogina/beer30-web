package com.github.darogina.beer30.assembler.api.v1;

import com.github.darogina.beer30.assembler.api.GenericResourceAssemler;
import com.github.darogina.beer30.controller.api.v1.AuthorAPIv1Controller;
import com.github.darogina.beer30.entity.AuthorEntity;
import com.github.darogina.beer30.model.api.v1.Author;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Named("authorResourceAssembler")
public class AuthorResourceAssembler extends GenericResourceAssemler<AuthorAPIv1Controller, AuthorEntity, Author> {

    private ModelMapper modelMapper;

    public AuthorResourceAssembler() {
        super(AuthorAPIv1Controller.class, Author.class);
    }

    @Override
    public Author toResource(AuthorEntity entity) {
        // will add also a link with rel self pointing itself
        Author resource = createResourceWithId(entity.getId(), entity);

        // adding a link with rel books pointing to the author's books
        resource.add(linkTo(methodOn(AuthorAPIv1Controller.class).findBooks(entity.getId())).withRel("books"));

        return resource;
    }

    @Override
    protected Author instantiateResource(AuthorEntity entity) {
        return entity == null ? null : modelMapper.map(entity, Author.class);
    }

    @PostConstruct
    private void init() {
        modelMapper = new ModelMapper();
    }
}
