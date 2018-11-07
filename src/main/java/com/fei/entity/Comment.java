package com.fei.entity;

import java.util.Date;

public class Comment {
    /**
     * ID
     */
    private Integer id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 用户评分
     */
    private String score;

    /**
     * 评论时间
     */
    private Date commentTips;

    /**
     * 用户评论详细内容
     */
    private String commentInfo;

    /**
     * ID
     * @return id ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 用户类型
     * @return user_type 用户类型
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 用户类型
     * @param userType 用户类型
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 用户评分
     * @return score 用户评分
     */
    public String getScore() {
        return score;
    }

    /**
     * 用户评分
     * @param score 用户评分
     */
    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    /**
     * 评论时间
     * @return comment_tips 评论时间
     */
    public Date getCommentTips() {
        return commentTips;
    }

    /**
     * 评论时间
     * @param commentTips 评论时间
     */
    public void setCommentTips(Date commentTips) {
        this.commentTips = commentTips;
    }

    /**
     * 用户评论详细内容
     * @return comment_info 用户评论详细内容
     */
    public String getCommentInfo() {
        return commentInfo;
    }

    /**
     * 用户评论详细内容
     * @param commentInfo 用户评论详细内容
     */
    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo == null ? null : commentInfo.trim();
    }
}