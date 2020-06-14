package com.example.blog.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/13
 * \* Time: 16:06
 * \* Description:
 * \
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto implements Serializable {

    private static final long serialVersionUID = 5059212992463947120L;

    private Long id;
    private String avatar;
    private String nickname;
}
