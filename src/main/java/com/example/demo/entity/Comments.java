package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long commentId;
	String Comment;
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comments(long commentId, String comment) {
		super();
		this.commentId = commentId;
		Comment = comment;
	}
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", Comment=" + Comment + "]";
	}

}
