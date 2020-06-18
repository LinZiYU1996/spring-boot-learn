package com.example.blog.core.vo;

import com.example.blog.core.entity.VblogTag;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/16
 * \* Time: 16:11
 * \* Description:
 * \
 */
public class TagVo extends VblogTag {

    private static final long serialVersionUID = 5059212992497947120L;

    private int articles;

    public int getArticles() {
        return articles;
    }

    public void setArticles(int articles) {
        this.articles = articles;
    }


}
