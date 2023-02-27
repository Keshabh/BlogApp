package com.demo.blog.repositories;
import org.springframework.data.jpa.repository. JpaRepository;
import com.demo.blog.entities.Category;
public interface CategoryRepo extends JpaRepository<Category, Integer>
{
}