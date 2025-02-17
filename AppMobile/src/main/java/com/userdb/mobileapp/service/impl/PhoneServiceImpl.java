package com.userdb.mobileapp.service.impl;

import com.userdb.mobileapp.convert.PhoneConvert;
import com.userdb.mobileapp.dto.responseDTO.PhoneResponseDTO;
import com.userdb.mobileapp.entity.Phone;
import com.userdb.mobileapp.repository.IPhoneRepository;
import com.userdb.mobileapp.repository.custom.IPhoneRepositoryCustom;
import com.userdb.mobileapp.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PhoneServiceImpl implements IPhoneService {
    @Autowired
    IPhoneRepository iphoneRepository;
    @Autowired
    PhoneConvert phoneConvert;
    @Autowired
    IPhoneRepositoryCustom phoneRepositoryCustom;
    @Override
    public List<PhoneResponseDTO> getPhonesByCategory(int categoryId) {
//        phone đó chưa có trong map mà  status ==0 thì thêm vào map gán quantity=0;
//        còn nếu có trong map  mà staus == 0 thì ko tăng quantity lên
        List<Phone> phones= iphoneRepository.findByCategoryCategoryID(categoryId);
        List<PhoneResponseDTO> phonesResponseDTOs = new ArrayList<>();
        Map<String, Phone> groupPhones = new HashMap<>();

        for (Phone phone : phones) {
            if(!groupPhones.containsKey(phone.getPhoneName())){
                groupPhones.put(phone.getPhoneName(), phone);
                PhoneResponseDTO phoneResponseDTO = new PhoneResponseDTO();
                phoneResponseDTO=phoneConvert.toPhoneResponseDTO(phone);
                phoneResponseDTO.setSoldQuantity(iphoneRepository.countByPhoneNameAndStatusFalse(phone.getPhoneName()));
                phoneResponseDTO.setRemainingQuantity(iphoneRepository.countByPhoneNameAndStatusTrue(phone.getPhoneName()));
                phonesResponseDTOs.add(phoneResponseDTO);
            }
        }
        return phonesResponseDTOs;
    }

    @Override
    public List<PhoneResponseDTO> getAllPhones() {
        List<Phone> phones= iphoneRepository.findAll();
        List<PhoneResponseDTO> phonesResponseDTOs = new ArrayList<>();
        Map<String, Phone> groupPhones = new HashMap<>();

        for (Phone phone : phones) {
            if(!groupPhones.containsKey(phone.getPhoneName())){
                groupPhones.put(phone.getPhoneName(), phone);
                PhoneResponseDTO phoneResponseDTO = new PhoneResponseDTO();
                phoneResponseDTO=phoneConvert.toPhoneResponseDTO(phone);
                phoneResponseDTO.setSoldQuantity(iphoneRepository.countByPhoneNameAndStatusFalse(phone.getPhoneName()));
                phoneResponseDTO.setRemainingQuantity(iphoneRepository.countByPhoneNameAndStatusTrue(phone.getPhoneName()));
                phonesResponseDTOs.add(phoneResponseDTO);
            }
        }
        // Sắp xếp danh sách phonesResponseDTOs theo soldQuantity giảm dần
        phonesResponseDTOs.sort((dto1, dto2) -> Integer.compare(dto2.getSoldQuantity(), dto1.getSoldQuantity()));
        return phonesResponseDTOs;
    }
    @Override
    public List<PhoneResponseDTO> getPhonesCreatedWithinLast7Days() {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(8);
        List<Phone> phones = iphoneRepository.findByCreateDateAfter(sevenDaysAgo);

        List<PhoneResponseDTO> phonesResponseDTOs = new ArrayList<>();
        Map<String, Phone> groupPhones = new HashMap<>();

        for (Phone phone : phones) {
            if (!groupPhones.containsKey(phone.getPhoneName())) {
                groupPhones.put(phone.getPhoneName(), phone);
                PhoneResponseDTO phoneResponseDTO = phoneConvert.toPhoneResponseDTO(phone);
                phoneResponseDTO.setSoldQuantity(iphoneRepository.countByPhoneNameAndStatusFalse(phone.getPhoneName()));
                phoneResponseDTO.setRemainingQuantity(iphoneRepository.countByPhoneNameAndStatusTrue(phone.getPhoneName()));
                phonesResponseDTOs.add(phoneResponseDTO);
            }
        }

        // Giới hạn chỉ lấy 10 sản phẩm mới nhất
        return phonesResponseDTOs.size() > 10 ? phonesResponseDTOs.subList(0, 10) : phonesResponseDTOs;
    }
}
