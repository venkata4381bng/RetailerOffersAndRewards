package com.retailerOffers.demo.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.retailerOffers.demo.model.Transaction;

@Repository
public class TransactionRepository {

    public List<Transaction> getAllTransactions() {
        return List.of(
            new Transaction("C1", 120, LocalDate.now().minusMonths(1)),
            new Transaction("C1", 75, LocalDate.now().minusMonths(2)),
            new Transaction("C1", 200, LocalDate.now().minusMonths(3)),
            new Transaction("C2", 90, LocalDate.now().minusMonths(1)),
            new Transaction("C2", 40, LocalDate.now().minusMonths(2))
        );
    }
}