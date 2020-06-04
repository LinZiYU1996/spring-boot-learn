package com.example.restfuljpa;

import com.example.restfuljpa.pojo.Book;
import com.example.restfuljpa.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestfulJpaApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    BookRepository repository;


    String[] authors =
            {
                  "余华",
                    "东野圭吾",
                    "林奕含",
                    "曹雪芹",
                    "卡勒德·胡赛尼"
            };


    String[] booknames =
            {
                "活着",
                    "白夜行",
                    "房思琪的初恋乐园",
                    "红楼梦",
              "追风筝的人"
            };
    @Test
    public void save() {

        for (int i = 0; i < authors.length; i++) {

                Book book = new Book();
                book.setName(booknames[i]);
                book.setAuthor(authors[i]);
            repository.save(book);

        }



    }
}
