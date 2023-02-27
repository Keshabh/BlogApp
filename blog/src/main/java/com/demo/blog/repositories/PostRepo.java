package com.demo.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.blog.entities.Category;
import com.demo.blog.entities.Post;
import com.demo.blog.entities.User;
import com.demo.blog.payloads.PostDto;

@Repository
public interface PostRepo extends JpaRepository<Post,Integer>{
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

}
