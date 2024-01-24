package org.example.sem5_dz.service;

import jakarta.annotation.PostConstruct;
import org.example.sem5_dz.model.Reader;
import org.example.sem5_dz.repository.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {
    private final ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @PostConstruct
    public void generateData() {
        readerRepository.save(new Reader(1L, "Игорь"));
        readerRepository.save(new Reader(2L, "Иван"));
        readerRepository.save(new Reader(3L, "Петр"));
        readerRepository.save(new Reader(4L, "Ольга"));
    }

    public Reader getReaderById(Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    public void deleteReaderById(Long id) {
        readerRepository.deleteById(id);
    }

    public Reader addReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }
}
