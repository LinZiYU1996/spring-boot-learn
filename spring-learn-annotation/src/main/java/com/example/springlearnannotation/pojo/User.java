package com.example.springlearnannotation.pojo;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/9
 * \* Time: 16:09
 * \* Description:
 * \
 */
public class User {

    private long id;

    private String userName;

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
}
