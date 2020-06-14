package com.example.blog.core.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.blog.core.entity.VblogArticle;
import com.example.blog.core.vo.ArticleArchivesVo;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * <p>
 * 文章表 Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */

@Mapper
public interface VblogArticleMapper extends BaseMapper<VblogArticle> {

   //发布文章按年-月汇总
    List<ArticleArchivesVo> queyArticleArchives(int limit);
}
