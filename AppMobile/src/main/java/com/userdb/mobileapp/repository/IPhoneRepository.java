package com.userdb.mobileapp.repository;

import com.userdb.mobileapp.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IPhoneRepository extends JpaRepository<Phone, Integer> {
    // Tìm tất cả điện thoại thuộc một danh mục cụ thể
    List<Phone> findByCategoryCategoryID(int categoryID);
    // Lấy tất cả các điện thoại, mỗi phoneName xuất hiện một lần
    //List<Phone> findDistinctByPhoneName();
    // Đếm số lượng điện thoại với status = 0 (đã bán)
    int countByPhoneNameAndStatusFalse(String phoneName);
    List<Phone> findByCreateDateAfter(LocalDateTime createDate);
    // Đếm số lượng điện thoại với status = 1 (chưa bán)
    int countByPhoneNameAndStatusTrue(String phoneName);
}