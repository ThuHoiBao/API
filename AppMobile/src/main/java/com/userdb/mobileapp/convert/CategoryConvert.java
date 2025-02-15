package com.userdb.mobileapp.convert;

import com.userdb.mobileapp.dto.responseDTO.CategoryResponseDTO;
import com.userdb.mobileapp.dto.responseDTO.PhoneResponseDTO;
import com.userdb.mobileapp.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component

public class CategoryConvert {
    @Autowired
    ModelMapper modelMapper;

    public CategoryResponseDTO toCategoryResponseDTO(Category category) {
        CategoryResponseDTO categoryResponseDTO = modelMapper.map(category, CategoryResponseDTO.class);
        return categoryResponseDTO;
    }
}
