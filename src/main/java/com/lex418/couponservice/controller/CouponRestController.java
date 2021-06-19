package com.lex418.couponservice.controller;

import com.lex418.couponservice.model.Coupon;
import com.lex418.couponservice.repo.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
    @Autowired
    CouponRepo couponRepo;

    @RequestMapping(value = "/coupons", method = RequestMethod.POST)
    public Coupon create(@RequestBody Coupon coupon){
        return couponRepo.save(coupon);
    }

    @RequestMapping(value = "/coupons/{code}", method = RequestMethod.GET)
    public Coupon getCoupon(@PathVariable("code") String code){
//        return couponRepo.findByCode(code).get();
        return couponRepo.findByCode(code);
    }
}
