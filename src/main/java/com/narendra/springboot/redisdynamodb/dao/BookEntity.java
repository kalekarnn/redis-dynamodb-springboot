package com.narendra.springboot.redisdynamodb.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.io.Serializable;
import java.util.Objects;

@DynamoDBTable(tableName = "BookEntity")
public class BookEntity implements Serializable {

    private static final long serialVersionUID = -3713176080551518639L;
    private String bookName;
    private String authorName;
    private String publication;
    private String isbn;
    private float price;

    @DynamoDBAttribute
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @DynamoDBAttribute
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @DynamoDBAttribute
    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    @DynamoDBHashKey
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @DynamoDBAttribute
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity bookEntity = (BookEntity) o;
        return Float.compare(bookEntity.price, price) == 0 &&
                Objects.equals(bookName, bookEntity.bookName) &&
                Objects.equals(authorName, bookEntity.authorName) &&
                Objects.equals(publication, bookEntity.publication) &&
                Objects.equals(isbn, bookEntity.isbn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bookName, authorName, publication, isbn, price);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publication='" + publication + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                '}';
    }
}
