package com.lex418.couponservice.repo;

import com.lex418.couponservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CouponRepo extends JpaRepository<Coupon,Long> {
//    Optional<Coupon> findByCode(String code);
    Coupon findByCode(String code);
}
