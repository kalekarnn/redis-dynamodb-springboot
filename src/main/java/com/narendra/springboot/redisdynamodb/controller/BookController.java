package com.narendra.springboot.redisdynamodb.controller;

import com.narendra.springboot.redisdynamodb.dao.BookEntity;
import com.narendra.springboot.redisdynamodb.external.BooksResponse;
import com.narendra.springboot.redisdynamodb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@CacheConfig(cacheNames = "books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public BooksResponse getAllBooks() {
        return new BooksResponse(bookService.getAllBooks());
    }

    @Cacheable(key = "#bookId")
    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public BookEntity getBookById(@PathVariable String bookId) {
        return bookService.getBookById(bookId);
    }

    @Cacheable(key = "#bookEntity.isbn")
    @RequestMapping(method = RequestMethod.POST)
    public BookEntity createBook(@RequestBody BookEntity bookEntity) {
        return bookService.createBook(bookEntity);
    }

    @CachePut(key = "#bookEntity.isbn")
    @RequestMapping(method = RequestMethod.PUT)
    public BookEntity updateBook(@RequestBody BookEntity bookEntity) {
        return bookService.updateBook(bookEntity);
    }

    @CacheEvict(key = "#bookId")
    @RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
    public void deleteBookById(@PathVariable String bookId) {
        bookService.deleteBookById(bookId);
    }
}
