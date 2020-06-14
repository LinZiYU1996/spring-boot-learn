package com.example.blog.core.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/12
 * \* Time: 11:30
 * \* Description:
 * \
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleArchivesVo {
    private String year;
    private String month;
    private Integer count;

}
