package com.github.darogina.beer30.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity(name = "BOOK")
@Audited
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BookEntity extends BaseEntity {

    @Transient
    private static final long serialVersionUID = 277510473444071876L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AUTHOR_ID")
    private AuthorEntity author;

    @Column
    private String title;

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof BookEntity)) return false;
//
//        BookEntity that = (BookEntity) o;
//
//        if (author != null ? !author.equals(that.author) : that.author != null) return false;
//        if (title != null ? !title.equals(that.title) : that.title != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = author != null ? author.hashCode() : 0;
//        result = 31 * result + (title != null ? title.hashCode() : 0);
//        return result;
//    }
}
