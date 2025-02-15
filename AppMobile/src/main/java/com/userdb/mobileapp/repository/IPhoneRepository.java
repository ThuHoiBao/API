package com.userdb.mobileapp.repository;

import com.userdb.mobileapp.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPhoneRepository extends JpaRepository<Phone, Integer> {
    // Tìm tất cả điện thoại thuộc một danh mục cụ thể
    List<Phone> findByCategoryCategoryID(int categoryID);
}