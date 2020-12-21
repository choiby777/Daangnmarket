package com.daangnmarket.Models;

public class Shop {
    private String name;
    private String location;
    private int commentCount;
    private String commnetUser;
    private String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getCommnetUser() {
        return commnetUser;
    }

    public void setCommnetUser(String commnetUser) {
        this.commnetUser = commnetUser;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
