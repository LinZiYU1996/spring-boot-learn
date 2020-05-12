package com.example.springlearnannotation.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/9
 * \* Time: 16:17
 * \* Description:
 * \
 */

@Component("user1")
public class User1 {

    @Value("1")
    private long id;
    @Value("user name 1")
    private String userName;

    @Value("nore")
    private String nore;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNore() {
        return nore;
    }

    public void setNore(String nore) {
        this.nore = nore;
    }

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", nore='" + nore + '\'' +
                '}';
    }
}
