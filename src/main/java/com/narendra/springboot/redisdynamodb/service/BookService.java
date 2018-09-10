package com.narendra.springboot.redisdynamodb.service;

import com.narendra.springboot.redisdynamodb.cache.BookEntityCache;
import com.narendra.springboot.redisdynamodb.dao.BookEntity;
import com.narendra.springboot.redisdynamodb.dao.BookEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookEntityRepository bookEntityRepository;

    @Autowired
    BookEntityCache bookEntityCache;

    public List<BookEntity> getAllBooks() {
        return new ArrayList<>(bookEntityCache.findAll());
    }

    public BookEntity createBook(BookEntity bookEntity) {
       /* System.out.println("started");

        for (int i =3 ; i< 1000; i++){
            BookEntity bookEntity1 = new BookEntity();
            bookEntity1.setBookName(bookEntity.getBookName()+""+i);
            bookEntity1.setAuthorName(bookEntity.getAuthorName()+""+i);
            bookEntity1.setPrice(bookEntity.getPrice()+i);
            bookEntity1.setPublication(bookEntity.getPublication()+""+i);
            bookEntity1.setIsbn(bookEntity.getIsbn()+""+i);
            bookEntityRepository.save(bookEntity1);
        }
        System.out.println("finish");*/

        return bookEntityRepository.save(bookEntity);
    }

    public BookEntity getBookById(String bookId) {
        Optional<BookEntity> bookEntity = bookEntityRepository.findById(bookId);
        return bookEntity.get();
    }

    public BookEntity updateBook(BookEntity bookEntity) {
        return bookEntityRepository.save(bookEntity);
    }

    public void deleteBookById(String bookId) {
        bookEntityRepository.deleteById(bookId);
    }
}
