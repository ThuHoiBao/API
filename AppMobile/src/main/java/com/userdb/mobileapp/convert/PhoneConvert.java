package com.userdb.mobileapp.convert;

import com.userdb.mobileapp.dto.responseDTO.CategoryResponseDTO;
import com.userdb.mobileapp.dto.responseDTO.PhoneResponseDTO;
import com.userdb.mobileapp.entity.Category;
import com.userdb.mobileapp.entity.Phone;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhoneConvert {
    @Autowired
    ModelMapper modelMapper;

    public PhoneResponseDTO toPhoneResponseDTO(Phone phone) {
        PhoneResponseDTO phoneResponseDTO = modelMapper.map(phone, PhoneResponseDTO.class);
        return phoneResponseDTO;
    }
}
