package com.userdb.mobileapp.controller;

import com.userdb.mobileapp.dto.responseDTO.CategoryResponseDTO;
import com.userdb.mobileapp.dto.responseDTO.PhoneResponseDTO;
import com.userdb.mobileapp.service.ICategoryService;
import com.userdb.mobileapp.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    IPhoneService phoneService;
    @GetMapping()
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }
     //Lấy tất cả điện thoại theo danh mục
    @GetMapping("/{categoryId}")
    public List<PhoneResponseDTO> getPhonesByCategory(@PathVariable int categoryId) {
        return phoneService.getPhonesByCategory(categoryId);
    }
}
