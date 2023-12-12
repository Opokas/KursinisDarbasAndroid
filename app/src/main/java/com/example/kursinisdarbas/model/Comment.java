package com.example.kursinisdarbas.model;

import android.os.Build;



import java.time.LocalDate;


public class Comment {

    private int id;
    private String commentTitle;
    private String commentBody;
    private LocalDate dateCreated;
    private String author;
    private int authorID;
    private int productID;
    private int orderID;

    public Comment(String commentTitle, String commentBody, String author,int authorID) {
        this.commentTitle = commentTitle;
        this.commentBody = commentBody;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.dateCreated = LocalDate.now();
        }
        this.author=author;
        this.authorID=authorID;
    }
//    public Comment(String commentTitle, String commentBody, String author,int authorID,int orderID) {
//        this.commentTitle = commentTitle;
//        this.commentBody = commentBody;
//        this.dateCreated = LocalDate.now();
//        this.author=author;
//        this.authorID=authorID;
//        this.orderID=orderID;
//    }
//    public Comment(String commentTitle, String commentBody, String author,int authorID,int productID) {
//        this.commentTitle = commentTitle;
//        this.commentBody = commentBody;
//        this.dateCreated = LocalDate.now();
//        this.author=author;
//        this.authorID=authorID;
//        this.productID=productID;
//    }
    @Override
    public String toString() {
        return commentTitle + ":" + dateCreated;
    }
}
