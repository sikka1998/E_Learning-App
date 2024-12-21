package com.soumenprogramming.elearning.dao;

import com.soumenprogramming.elearning.model.SubscriptionDetails;
import com.soumenprogramming.elearning.repository.SubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionDetailsService {

    @Autowired
    private SubscriptionRepo subscriptionRepo;

    // Save a subscription
    public SubscriptionDetails save(SubscriptionDetails subscriptionDetails) {
        return subscriptionRepo.save(subscriptionDetails);
    }

    // Find a single subscription by ID
    public SubscriptionDetails findBySubscriptionId(int subscriptionId) {
        return subscriptionRepo.findBySubscriptionId(subscriptionId);
    }

    // Find all subscriptions with a specific status
    public List<SubscriptionDetails> findBySubscriptionStatus(String subscriptionStatus) {
        return subscriptionRepo.findBySubscriptionStatus(subscriptionStatus);
    }

    // Find all subscriptions with a specific mode
    public List<SubscriptionDetails> findBySubscriptionMode(String subscriptionMode) {
        return subscriptionRepo.findBySubscriptionMode(subscriptionMode);
    }

    // Update a subscription
    public SubscriptionDetails update(int subscriptionId, SubscriptionDetails updatedSubscriptionDetails) {
        SubscriptionDetails existingSubscriptionDetails = subscriptionRepo.findBySubscriptionId(subscriptionId);
        if (existingSubscriptionDetails != null) {
            existingSubscriptionDetails.setSubscriptionStatus(updatedSubscriptionDetails.getSubscriptionStatus());
            existingSubscriptionDetails.setSubscriptionMode(updatedSubscriptionDetails.getSubscriptionMode());
            existingSubscriptionDetails.setSubscriptionStartDate(updatedSubscriptionDetails.getSubscriptionStartDate());
            existingSubscriptionDetails.setSubscriptionEndDate(updatedSubscriptionDetails.getSubscriptionEndDate());
            return subscriptionRepo.save(existingSubscriptionDetails);
        } else {
            return null;
        }
    }

    // Delete a subscription
    public boolean deleteBySubscriptionId(int subscriptionId) {
        SubscriptionDetails existingSubscriptionDetails = subscriptionRepo.findBySubscriptionId(subscriptionId);
        if (existingSubscriptionDetails != null) {
            subscriptionRepo.delete(existingSubscriptionDetails);
            return true;
        }
        return false;
    }
}
