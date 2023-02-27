package com.demo.blog.services;

import java.util.List;

import com.demo.blog.payloads.PostDto;

public interface PostService {
	//create
	PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
	
	//upadte
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get posts
	PostDto getPostById(Integer postId);
	
	//get all posts
	List<PostDto> getallPost();
	
	//get post by userid
	List<PostDto> getPostByUser(Integer userId);
	
	//get post by categoryid
	List<PostDto> getPostByCategory(Integer categoryid);
	
	//get post by search
	List<PostDto> searchPosts(String keyword);

}
