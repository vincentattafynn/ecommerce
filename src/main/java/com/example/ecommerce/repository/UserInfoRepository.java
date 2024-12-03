package com.example.ecommerce.repository;

import com.example.ecommerce.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long>{
    UserInfo findByFirstName(String firstName);
    List<UserInfo> findByIsOwner(Boolean isOwner);
    //username is the same as email.
    Optional<UserInfo> findByUsername(String username);
}
