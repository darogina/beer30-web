package com.github.darogina.beer30.repository;

import com.github.darogina.beer30.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
