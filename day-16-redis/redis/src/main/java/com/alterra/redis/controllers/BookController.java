package com.alterra.redis.controllers;

import com.alterra.redis.entities.BaseBookResponse;
import com.alterra.redis.entities.Book;
import com.alterra.redis.entities.RegisterBookRequest;
import com.alterra.redis.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public BaseBookResponse<Book> registerBook(@RequestBody RegisterBookRequest registerBookRequest){
        UUID uuid = UUID.randomUUID();

        Book book = new Book(uuid.toString(),
                registerBookRequest.getISBN(),
                registerBookRequest.getTitle(),
                registerBookRequest.getAuthor(),
                registerBookRequest.getDescription(),
                registerBookRequest.getCategory());

        Book registeredBook =bookRepository.save(book);

        return new BaseBookResponse<>(
                "success",
                "book registered",
                registeredBook
        );
    }

    @GetMapping()
    public BaseBookResponse<List<Book>> getAllBooks() {
        List<Book> books = new ArrayList<>();

        bookRepository.findAll().forEach(books::add);

        return new BaseBookResponse<>(
                "success",
                "all books",
                books
        );
    }

    @GetMapping("{id}")
    public BaseBookResponse<Book> getSingleBook(@PathVariable String id) {

        Book book = bookRepository.findById(id).orElseThrow();

        return new BaseBookResponse<>(
                "success",
                "all books",
                book
        );
    }

    @PatchMapping("{id}")
    public BaseBookResponse<Book> updateBook(@PathVariable String id, @RequestBody RegisterBookRequest registerBookRequest) {
        Book book = bookRepository.findById(id).orElseThrow();

        book.setISBN(registerBookRequest.getISBN());
        book.setTitle(registerBookRequest.getTitle());
        book.setAuthor(registerBookRequest.getAuthor());
        book.setDescription(registerBookRequest.getDescription());
        book.setCategory(registerBookRequest.getCategory());

        Book updatedBook = bookRepository.save(book);

        return new BaseBookResponse<>(
                "success",
                "book updated",
                updatedBook
        );
    }

    @DeleteMapping("{id}")
    public BaseBookResponse<String> deleteBook(@PathVariable String id) {
        bookRepository.deleteById(id);

        return new BaseBookResponse<>(
                "success",
                "book deleted",
                "book id - " + id
        );
    }



}
