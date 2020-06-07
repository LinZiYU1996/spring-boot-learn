package com.example.elasticsearch;

import com.example.elasticsearch.entity.Article;
import com.example.elasticsearch.repository.ArticleRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class ElasticsearchApplicationTests {


    @Autowired
    ArticleRepository repository;
    @Test
    void contextLoads() {
    }


    public String gen() {
        int length = 10;

        boolean useLetters = true;

        boolean useNumbers = false;

        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return generatedString;
    }

    @Test
    public void t1() {

        Article article = new Article();
        for (int i = 2; i < 200; i++) {
            article.setId(i);
            article.setTitle(gen());
            article.setAuthor(gen());
            article.setContent(gen());
            repository.save(article);

        }



    }
}
