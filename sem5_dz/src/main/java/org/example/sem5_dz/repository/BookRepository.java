package org.example.sem5_dz.repository;

import org.example.sem5_dz.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public Book findBookByName(String name);
}
