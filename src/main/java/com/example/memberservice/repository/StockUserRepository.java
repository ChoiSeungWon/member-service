package com.example.memberservice.repository;

import com.example.memberservice.entity.StockUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockUserRepository extends CrudRepository<StockUser, Integer> {

    List<StockUser> findByUserId(String userId);
}
