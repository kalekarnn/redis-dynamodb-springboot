package com.narendra.springboot.redisdynamodb.external;

import com.narendra.springboot.redisdynamodb.dao.BookEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class BooksResponse implements Serializable {

    private static final long serialVersionUID = -7167785637091087120L;
    List<BookEntity> bookEntities;

    public BooksResponse(List<BookEntity> bookEntities) {
        this.bookEntities = bookEntities;
    }

    public List<BookEntity> getBookEntities() {
        return bookEntities;
    }

    public void setBookEntities(List<BookEntity> bookEntities) {
        this.bookEntities = bookEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooksResponse that = (BooksResponse) o;
        return Objects.equals(bookEntities, that.bookEntities);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bookEntities);
    }

    @Override
    public String toString() {
        return "BooksResponse{" +
                "bookEntities=" + bookEntities +
                '}';
    }
}

