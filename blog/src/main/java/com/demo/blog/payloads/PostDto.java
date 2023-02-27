package com.demo.blog.payloads;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.demo.blog.entities.Category;
import com.demo.blog.entities.User;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	@NotEmpty
	private String title;
	@Size(min=3,message="content length should be atleast 3 characters")
	private String content;
	private Date addedDate;
	private String imageName;
	private CategoryDto category;
	private UserDto user;
}
