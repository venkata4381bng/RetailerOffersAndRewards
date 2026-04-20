package com.retailerOffers.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.retailerOffers.demo.service.RewardService;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RetailerOffersAndRewardsApplicationTests {
    @Test
    void testCalculation() {
        RewardService service = new RewardService(null);

        int points = serviceTestHelper(service, 120);
        assertEquals(90, points);
    }

    private int serviceTestHelper(RewardService service, double amount) {
        try {
            var method = RewardService.class.getDeclaredMethod("calculatePoints", double.class);
            method.setAccessible(true);
            return (int) method.invoke(service, amount);
        } catch (Exception e) {
            return 0;
        }
    }
}