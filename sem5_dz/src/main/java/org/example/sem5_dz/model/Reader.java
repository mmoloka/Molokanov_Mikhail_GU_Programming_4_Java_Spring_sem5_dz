package org.example.sem5_dz.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "readers")
@Data
public class Reader {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "reader")
    private Issue issue;

    public Reader(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Reader() {
    }
}
