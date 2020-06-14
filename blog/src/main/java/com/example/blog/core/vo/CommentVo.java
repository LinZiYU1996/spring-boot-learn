package com.example.blog.core.vo;

import com.example.blog.core.entity.VblogComment;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/13
 * \* Time: 16:00
 * \* Description:
 * \
 */
public class CommentVo extends VblogComment {

    private String avatar;
    private String nickname;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


}
