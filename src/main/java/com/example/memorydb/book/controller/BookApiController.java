package com.example.memorydb.book.controller;

import com.example.memorydb.book.db.entity.BookEntity;
import com.example.memorydb.book.db.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookApiController {

    private final BookRepository bookRepository;

    @GetMapping("/books")
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    public BookEntity save(@RequestBody BookEntity bookEntity) {
        BookEntity save = bookRepository.save(bookEntity);
        return save;
    }

    @GetMapping("/books/{id}")
    public BookEntity findById(@PathVariable Long id) {
        Optional<BookEntity> byId = bookRepository.findById(id);
        return byId.get();
    }


    @DeleteMapping("/books/{id}")
    public void deleteById(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}

//    HTTP GET /device-management/managed-devices  			//Get all devices
//        HTTP POST /device-management/managed-devices  			//Create new Device
//
//        HTTP GET /device-management/managed-devices/{id}  		//Get device for given Id
//        HTTP PUT /device-management/managed-devices/{id}  		//Update device for given Id
//        HTTP DELETE /device-management/managed-devices/{id}  	//Delete device for given Id
