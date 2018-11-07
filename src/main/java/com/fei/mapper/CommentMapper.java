package com.fei.mapper;

import com.fei.entity.Comment;

import java.util.List;

public interface CommentMapper {
    /**
     *
     * @mbggenerated 2018-11-07
     */
    int insert(Comment record);

    /**
     *
     * @mbggenerated 2018-11-07
     */
    int insertSelective(Comment record);

    /**
     * 批量插入数据
     * @param dataList
     * @return
     */
    int insertBatch(List<Comment> dataList);
}