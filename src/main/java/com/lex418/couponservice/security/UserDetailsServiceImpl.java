package com.lex418.couponservice.security;

import com.lex418.couponservice.model.User;
import com.lex418.couponservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findUserByEmail(email).get();

        if(user==null){
            throw new UsernameNotFoundException("user not found for email "+email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
    }
}
