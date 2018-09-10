package com.narendra.springboot.redisdynamodb.cache;

import com.narendra.springboot.redisdynamodb.dao.BookEntity;
import com.narendra.springboot.redisdynamodb.dao.BookEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class BookEntityCache {

    @Autowired
    private BookEntityRepository bookEntityRepository;

    @Autowired
    RedisTemplate<String, BookEntity> redisTemplate;

    public List findAll() {
        Set cachedBooks = redisTemplate.keys("books*");
        //System.out.println(Collections.singletonList(cachedBooks));
        //System.out.println(redisTemplate.opsForValue().multiGet(cachedBooks));
        if (cachedBooks.size() == bookEntityRepository.count()) {
            return redisTemplate.opsForValue().multiGet(cachedBooks);
        }
        return bookEntityRepository.findAll();
    }
}
