package com.github.darogina.beer30.controller.api.v1;

import com.github.darogina.beer30.assembler.api.v1.AuthorResourceAssembler;
import com.github.darogina.beer30.assembler.api.v1.BookResourceAssembler;
import com.github.darogina.beer30.controller.ServiceBasedRestController;
import com.github.darogina.beer30.entity.AuthorEntity;
import com.github.darogina.beer30.entity.BaseEntity;
import com.github.darogina.beer30.entity.BookEntity;
import com.github.darogina.beer30.exception.NotFoundException;
import com.github.darogina.beer30.model.api.v1.Author;
import com.github.darogina.beer30.model.api.v1.Book;
import com.github.darogina.beer30.service.AuthorService;
import com.github.darogina.beer30.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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