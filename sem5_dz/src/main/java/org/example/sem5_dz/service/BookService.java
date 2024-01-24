package org.example.sem5_dz.service;

import jakarta.annotation.PostConstruct;
import org.example.sem5_dz.model.Book;
import org.example.sem5_dz.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void generateData() {
        bookRepository.save(new Book(1L, "война и мир"));
        bookRepository.save(new Book(2L, "мертвые души"));
        bookRepository.save(new Book(3L, "чистый код"));
        bookRepository.save(new Book(4L, "мастер и маргарита"));
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
