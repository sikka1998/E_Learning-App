package com.soumenprogramming.elearning.repository;

import com.soumenprogramming.elearning.model.SubscriptionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepo extends JpaRepository<SubscriptionDetails, Integer> {

    // Retrieves a single record by subscriptionId
    SubscriptionDetails findBySubscriptionId(int subscriptionId);


    // Retrieves a list of records with the same subscriptionStatus
    List<SubscriptionDetails> findBySubscriptionStatus(String subscriptionStatus);

    // Retrieves a list of records with the same subscriptionMode
    List<SubscriptionDetails> findBySubscriptionMode(String subscriptionMode);
}

