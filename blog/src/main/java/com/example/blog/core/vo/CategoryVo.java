package com.example.blog.core.vo;

import com.example.blog.core.entity.VblogCategory;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/16
 * \* Time: 10:04
 * \* Description:
 * \
 */
public class CategoryVo extends VblogCategory {

    /**
     * 序列化
     */
    private static final long serialVersionUID = -2975739216517528014L;

    private int articles;

    public int getArticles() {
        return articles;
    }

    public void setArticles(int articles) {
        this.articles = articles;
    }
}
