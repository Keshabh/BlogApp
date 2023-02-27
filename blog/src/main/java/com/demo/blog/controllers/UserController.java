package com.demo.blog.controllers;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.blog.payloads.ApiResponse;
import com.demo.blog.payloads.UserDto;
import com.demo.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	// POST-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser (@Valid @RequestBody UserDto userDto) {
	UserDto createUserDto = this.userService.createUser (userDto);
	return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	// PUT- update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser (@RequestBody UserDto userDto,@PathVariable Integer userId) {
	UserDto updatedUserDto = this.userService.updateUser (userDto,userId);
	return ResponseEntity.ok(updatedUserDto);
	}
	// DELETE -delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser (@PathVariable Integer userId) {
	this.userService.deleteUser(userId);
	return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",false),HttpStatus.OK);
	}
	// GET user get
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById (@PathVariable Integer userId) {
	UserDto fetchedUser =  this.userService.getUserById(userId);
	return ResponseEntity.ok(fetchedUser);
	}
	
	// GET all user get
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers () {
	List<UserDto> allUsers =  this.userService.getAllUsers();
	return ResponseEntity.ok(allUsers);
	}
}
