package com.example.memberservice.controller;

import com.example.memberservice.entity.StockUser;
import com.example.memberservice.repository.StockUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StockController {

    private StockUserRepository stockUserRepository;

    public StockController(StockUserRepository stockUserRepository) {
        this.stockUserRepository = stockUserRepository;
    }

    @GetMapping("/user")
    public List<StockUser> stockUserList(@RequestParam String userId) {
        return stockUserRepository.findByUserId(userId);
    }

    @PostMapping("/user")
    public StockUser addStockUser(@RequestBody StockUser stockUser) {
        stockUser.setCreatedAt(new Date());
        StockUser stockUserEntity = stockUserRepository.save(stockUser);
        return stockUserEntity;
    }

    @GetMapping("/user/{id}")
    public Optional<StockUser> stockUser(@PathVariable("id") Integer id) {
        return stockUserRepository.findById(id);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteStockUser(@PathVariable("id") Integer id) {
        Optional<StockUser> user = stockUserRepository.findById(id);
        if (user.isPresent()) {
            stockUserRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
