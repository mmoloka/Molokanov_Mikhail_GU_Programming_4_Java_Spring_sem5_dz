package org.example.sem5_dz;

import org.example.sem5_dz.model.Book;
import org.example.sem5_dz.model.Reader;
import org.example.sem5_dz.repository.BookRepository;
import org.example.sem5_dz.repository.IssueRepository;
import org.example.sem5_dz.repository.ReaderRepository;
import org.example.sem5_dz.service.BookService;
import org.example.sem5_dz.service.IssueService;
import org.example.sem5_dz.service.ReaderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Sem5DzApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Sem5DzApplication.class, args);

        BookRepository bookRepository = context.getBean(BookRepository.class);
        ReaderRepository readerRepository = context.getBean(ReaderRepository.class);
        IssueRepository issueRepository = context.getBean(IssueRepository.class);
        BookService bookService = context.getBean(BookService.class);
        ReaderService readerService = context.getBean(ReaderService.class);
        IssueService issueService = context.getBean(IssueService.class);

        System.out.println(bookRepository.findBookByName("мертвые души"));
        System.out.println(readerRepository.findReaderByName("Петр"));

        bookService.deleteBookById(4L);
        bookService.addBook(new Book(99L, "книга джунглей"));

        readerService.deleteReaderById(4L);
        readerService.addReader(new Reader(99L, "Анна"));

        System.out.println(issueService.getAllIssues());
        System.out.println(issueRepository.findIssuesByBook(bookRepository.findBookByName("чистый код")));
        System.out.println(issueRepository.findIssuesByReader(readerRepository.findReaderByName("Петр")));

    }

}
