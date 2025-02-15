package com.userdb.mobileapp.service.impl;

import com.userdb.mobileapp.convert.CategoryConvert;
import com.userdb.mobileapp.dto.responseDTO.CategoryResponseDTO;
import com.userdb.mobileapp.entity.Category;
import com.userdb.mobileapp.repository.ICategoryRepository;
import com.userdb.mobileapp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private CategoryConvert categoryConvert;
    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDTO> categoriesDTO = new ArrayList<CategoryResponseDTO>();
        for (Category category : categories) {
            CategoryResponseDTO categoryDTO = new CategoryResponseDTO();
            categoryDTO = categoryConvert.toCategoryResponseDTO(category);
            categoriesDTO.add(categoryDTO);
        }
        return categoriesDTO;
    }
}
