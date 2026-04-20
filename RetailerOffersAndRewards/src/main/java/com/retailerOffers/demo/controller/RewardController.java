package com.retailerOffers.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.retailerOffers.demo.model.RewardResponse;
import com.retailerOffers.demo.service.RewardService;

import java.util.List;

@RestController
@RequestMapping("/api/offersandrewards")
public class RewardController {

    private final RewardService service;

    public RewardController(RewardService service) {
        this.service = service;
    }

    @GetMapping
    public List<RewardResponse> getRewards() {
        return service.calculateRewards();
    }
}