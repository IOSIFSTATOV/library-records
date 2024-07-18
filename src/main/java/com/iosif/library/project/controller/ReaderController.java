package com.iosif.library.project.controller;

import com.iosif.library.project.PersonDto.ReaderDto;
import com.iosif.library.project.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
public class ReaderController {

    @Autowired
    private final ReaderService readerService;

    @PostMapping
    public void addReader(@RequestBody ReaderDto readerDto) {
        this.readerService.addReader(readerDto);
    }

    @GetMapping
    public List<ReaderDto> getAllReaders() {
        return this.readerService.getAllReaders();
    }

    @GetMapping("/{id}")
    public ReaderDto getReaderById(@PathVariable Integer id) {
        return this.readerService.getReaderById(id);
    }

}
