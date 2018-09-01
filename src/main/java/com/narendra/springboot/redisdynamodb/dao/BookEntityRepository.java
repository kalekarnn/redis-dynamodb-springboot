package com.narendra.springboot.redisdynamodb.dao;


import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface BookEntityRepository extends CrudRepository<BookEntity, String> {

    List<BookEntity> findAll();

    BookEntity save(BookEntity bookEntity);
}
