package org.example.sem5_dz.repository;

import org.example.sem5_dz.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    public Reader findReaderByName(String name);
}
