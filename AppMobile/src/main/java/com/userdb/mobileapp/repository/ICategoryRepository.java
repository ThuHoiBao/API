package com.userdb.mobileapp.repository;

import com.userdb.mobileapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
