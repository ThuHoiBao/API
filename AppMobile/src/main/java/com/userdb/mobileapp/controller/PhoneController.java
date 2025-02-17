package com.userdb.mobileapp.controller;

import com.userdb.mobileapp.dto.responseDTO.PhoneResponseDTO;
import com.userdb.mobileapp.entity.Phone;
import com.userdb.mobileapp.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {
    @Autowired
    IPhoneService phoneService;

    @GetMapping
    public List<PhoneResponseDTO> getAllPhones() {
        return phoneService.getAllPhones();
    }
    @GetMapping("/recent")
    public List<PhoneResponseDTO> getPhonesCreatedWithinLast7Days() {
        return phoneService.getPhonesCreatedWithinLast7Days();
    }
}
