package org.example.sem5_dz.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "issues")
@Data
public class Issue {

    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private Book book;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "readerId", referencedColumnName = "id")
    private Reader reader;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public Issue() {
    }

    public Issue(Long id, Book book, Reader reader) {
        this.id = id;
        this.book = book;
        this.reader = reader;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", book=" + book.getId() +
                ", reader=" + reader.getId() +
                ", timestamp=" + timestamp +
                '}';
    }
}
