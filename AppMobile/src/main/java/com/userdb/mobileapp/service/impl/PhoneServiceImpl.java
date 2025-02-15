package com.userdb.mobileapp.service.impl;

import com.userdb.mobileapp.convert.PhoneConvert;
import com.userdb.mobileapp.dto.responseDTO.PhoneResponseDTO;
import com.userdb.mobileapp.entity.Phone;
import com.userdb.mobileapp.repository.IPhoneRepository;
import com.userdb.mobileapp.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PhoneServiceImpl implements IPhoneService {
    @Autowired
    IPhoneRepository iphoneRepository;
    @Autowired
    PhoneConvert phoneConvert;

    @Override
    public List<PhoneResponseDTO> getPhonesByCategory(int categoryId) {
        List<Phone> phones= iphoneRepository.findByCategoryCategoryID(categoryId);
        List<PhoneResponseDTO> phonesResponseDTOs = new ArrayList<>();
        for (Phone phone : phones){
            PhoneResponseDTO phoneResponseDTO =new PhoneResponseDTO();
            phoneResponseDTO = phoneConvert.toPhoneResponseDTO(phone);
            phonesResponseDTOs.add(phoneResponseDTO);
        }

        return phonesResponseDTOs;
    }
}
