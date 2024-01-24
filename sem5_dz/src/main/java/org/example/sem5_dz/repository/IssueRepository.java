package org.example.sem5_dz.repository;

import org.example.sem5_dz.model.Book;
import org.example.sem5_dz.model.Issue;
import org.example.sem5_dz.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

    List<Issue> findIssuesByBook(Book book);

    List<Issue> findIssuesByReader(Reader reader);
}
