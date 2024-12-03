package com.example.ecommerce.service;

import com.example.ecommerce.entity.UserInfo;
import com.example.ecommerce.repository.UserInfoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserInfoRepository repository;
    private final PasswordEncoder encoder;
    public UserService(UserInfoRepository repository, PasswordEncoder encoder ){
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //username is the same as the email
        Optional<UserInfo> userDetail = repository.findByUsername(username);

        //converting userDetail to spring userDetails
            return userDetail.map(UserInfoDetails::new).orElseThrow(() ->   new UsernameNotFoundException("User not found " + username));
    }
}
