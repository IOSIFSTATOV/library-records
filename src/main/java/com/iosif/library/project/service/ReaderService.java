package com.iosif.library.project.service;

import com.iosif.library.project.dto.ReaderDto;
import com.iosif.library.project.exception.DataNotFoundException;
import com.iosif.library.project.model.Reader;
import com.iosif.library.project.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ReaderService {

    @Autowired
    private final ReaderRepository readerRepository;

    public void addReader(ReaderDto readerDto) {
        Reader reader = new Reader(readerDto.getNameSurname(), readerDto.getAge(),readerDto.getReservedBook());
        readerRepository.save(reader);
    }

    public List<ReaderDto> getAllReaders() {
        Iterable<Reader> readers = readerRepository.findAll();
        return StreamSupport.stream(readers.spliterator(), false)
                .map(reader -> new ReaderDto(reader.getNameSurname(), reader.getAge(), reader.getReservedBook()))
                .toList();
    }

    public ReaderDto getReaderById(Integer id) {
        Optional<Reader> reader = readerRepository.findById(id);
        if (reader.isEmpty()) {
            throw new DataNotFoundException("Reader by id : " + id + " not found");
        }
        Reader foundReader = reader.get();
        return new ReaderDto(foundReader.getNameSurname(), foundReader.getAge(), foundReader.getReservedBook());
    }

}
