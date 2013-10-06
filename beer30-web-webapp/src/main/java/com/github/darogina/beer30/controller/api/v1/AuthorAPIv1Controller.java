package com.github.darogina.beer30.controller.api.v1;

import com.github.darogina.beer30.assembler.api.v1.AuthorResourceAssembler;
import com.github.darogina.beer30.assembler.api.v1.BookResourceAssembler;
import com.github.darogina.beer30.controller.ServiceBasedRestController;
import com.github.darogina.beer30.entity.AuthorEntity;
import com.github.darogina.beer30.entity.BaseEntity;
import com.github.darogina.beer30.exception.NotFoundException;
import com.github.darogina.beer30.model.api.v1.Author;
import com.github.darogina.beer30.model.api.v1.Book;
import com.github.darogina.beer30.service.AuthorService;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
@ExposesResourceFor(Author.class)
@RequestMapping(value = "/api/v1/author")
public class AuthorAPIv1Controller extends ServiceBasedRestController<Author, Long, AuthorService, AuthorResourceAssembler> {

    @Inject
    private BookResourceAssembler bookResourceAssembler;

    @Override @Inject
    protected void setService(AuthorService service) {
        this.service = service;
    }

    @Override @Inject
    protected void setResourceAssembler(AuthorResourceAssembler resourceAssembler) {
        this.resourceAssembler = resourceAssembler;
    }

    @Override
    protected BaseEntity toEntity(Author model) {
        if (model == null) {
            return null;
        }

        return modelMapper.map(model, AuthorEntity.class);
    }

    @RequestMapping(value = "/{authorId}/books", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Book> findBooks(@PathVariable Long authorId) {
        AuthorEntity author = service.findById(authorId);

        if (author == null) {
            throw new NotFoundException();
        }

        return bookResourceAssembler.toResources(author.getBooks());
    }

}