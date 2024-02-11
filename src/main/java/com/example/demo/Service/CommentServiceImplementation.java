package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Comments;
import com.example.demo.repository.CommentRepository;
@Service
public class CommentServiceImplementation implements CommentService{
@Autowired
CommentRepository commentrepo;
	
	
	@Override
	public List<Comments> commentList() {
		
		return commentrepo.findAll();
	}


	@Override
	public String addComment(Comments comment) {
		commentrepo.save(comment);
		return "comment added";
	}

}
