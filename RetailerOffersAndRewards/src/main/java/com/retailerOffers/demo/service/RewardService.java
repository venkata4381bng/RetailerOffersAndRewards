package com.retailerOffers.demo.service;

import com.retailerOffers.demo.model.RewardResponse;

import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;
import com.retailerOffers.demo.model.Transaction;
import com.retailerOffers.demo.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class RewardService {

    private final TransactionRepository repository;

    public RewardService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<RewardResponse> calculateRewards() {

        List<Transaction> transactions = repository.getAllTransactions();

        Map<String, List<Transaction>> customerMap =
                transactions.stream().collect(Collectors.groupingBy(Transaction::getCustomerId));

        List<RewardResponse> responses = new ArrayList<>();

        for (String customerId : customerMap.keySet()) {

            Map<String, Integer> monthlyPoints = new HashMap<>();

            for (Transaction t : customerMap.get(customerId)) {
                int points = calculatePoints(t.getAmount());

                String month = t.getDate()
                        .getMonth()
                        .getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

                monthlyPoints.put(month, monthlyPoints.getOrDefault(month, 0) + points);
            }

            int total = monthlyPoints.values().stream().mapToInt(Integer::intValue).sum();

            responses.add(new RewardResponse(customerId, monthlyPoints, total));
        }

        return responses;
    }

    private int calculatePoints(double amount) {
        int points = 0;

        if (amount > 100) {
            points += (int)((amount - 100) * 2);
            amount = 100;
        }
        if (amount > 50) {
            points += (int)(amount - 50);
        }

        return points;
    }
}