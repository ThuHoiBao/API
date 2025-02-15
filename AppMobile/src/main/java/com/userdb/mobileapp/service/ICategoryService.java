package com.userdb.mobileapp.service;

import com.userdb.mobileapp.dto.responseDTO.CategoryResponseDTO;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponseDTO> getAllCategories();
}
