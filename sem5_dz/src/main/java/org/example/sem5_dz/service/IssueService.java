package org.example.sem5_dz.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.sem5_dz.model.Issue;
import org.example.sem5_dz.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;
    private final BookService bookService;
    private final ReaderService readerService;


    @PostConstruct
    public void generateData() {
        issueRepository.save(new Issue(
                1L,
                bookService.getBookById(1L),
                readerService.getReaderById(1L))
        );
        issueRepository.save(new Issue(
                2L,
                bookService.getBookById(3L),
                readerService.getReaderById(2L))
        );
        issueRepository.save(new Issue(
                3L,
                bookService.getBookById(2L),
                readerService.getReaderById(3L))
        );
    }

    public Issue addIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    public Issue getIssueById(Long id) {
        return issueRepository.findById(id).orElse(null);
    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }
}
