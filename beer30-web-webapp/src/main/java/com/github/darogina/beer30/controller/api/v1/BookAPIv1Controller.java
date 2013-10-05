package com.github.darogina.beer30.controller.api.v1;

import com.github.darogina.beer30.assembler.api.v1.BookResourceAssembler;
import com.github.darogina.beer30.controller.ServiceBasedRestController;
import com.github.darogina.beer30.entity.BaseEntity;
import com.github.darogina.beer30.entity.BookEntity;
import com.github.darogina.beer30.model.api.v1.Book;
import com.github.darogina.beer30.service.BookService;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
@ExposesResourceFor(Book.class)
@RequestMapping(value = "/api/v1/book")
public class BookAPIv1Controller extends ServiceBasedRestController<Book, Long, BookService, BookResourceAssembler> {

    @Override @Inject
    protected void setService(BookService service) {
        this.service = service;
    }

    @Override @Inject
    protected void setResourceAssembler(BookResourceAssembler resourceAssembler) {
        this.resourceAssembler = resourceAssembler;
    }

    @Override
    protected BaseEntity toEntity(Book model) {
        if (model == null) {
            return null;
        }

        return modelMapper.map(model, BookEntity.class);
    }

}
