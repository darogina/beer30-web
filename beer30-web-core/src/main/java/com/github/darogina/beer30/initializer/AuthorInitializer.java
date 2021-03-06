package com.github.darogina.beer30.initializer;

import com.github.darogina.beer30.entity.AuthorEntity;
import com.github.darogina.beer30.entity.BookEntity;
import com.github.darogina.beer30.service.AuthorService;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashSet;
import java.util.Set;

@Named("authorInitializer")
public class AuthorInitializer {

    private static final String AUTHOR_NAME = "Author Name";
    private static final String BOOK_TITLE = "Book Title";

    @Inject
    @Named("authorService")
    private AuthorService authorService;

    @PostConstruct
    public void setup() {
        authorService.deleteAll();

        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(AUTHOR_NAME);

        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(BOOK_TITLE);
        bookEntity.setAuthor(authorEntity);

        Set<BookEntity> books = new HashSet<>();
        books.add(bookEntity);

        authorEntity.setBooks(books);

        authorEntity = authorService.create(authorEntity);
        Assert.notNull(authorEntity);
        Assert.notNull(authorEntity.getId());
        Assert.notEmpty(authorEntity.getBooks());
    }
}
