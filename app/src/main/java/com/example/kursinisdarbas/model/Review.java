package com.example.kursinisdarbas.model;





public class Review extends Comment{
    private int rating;

    public Review(String commentTitle, String commentBody, String author,int authorID,int rating){
        super(commentTitle,commentBody,author,authorID);
        this.rating=rating;
    }

//    @Override
//    public String toString() {
//        return this.getAuthor()+" "+ this.getRating()+ "/5"+"\n"+this.getDateCreated()+"\n"+ this.getCommentTitle()+"\n"+ this.getCommentBody();
//    }
}
