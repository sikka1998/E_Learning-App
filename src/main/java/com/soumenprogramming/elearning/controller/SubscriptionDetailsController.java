package com.soumenprogramming.elearning.controller;

import com.soumenprogramming.elearning.dao.SubscriptionDetailsService;
import com.soumenprogramming.elearning.model.SubscriptionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubscriptionDetailsController {

    @Autowired
    private SubscriptionDetailsService subscriptionDetailsService;

    // Save a new subscription
    @PostMapping("/subscription")
    public ResponseEntity<SubscriptionDetails> saveSubscriptionDetails(@RequestBody SubscriptionDetails subscriptionDetails) {
        SubscriptionDetails savedSubscriptionDetails = subscriptionDetailsService.save(subscriptionDetails);
        return ResponseEntity.ok(savedSubscriptionDetails);
    }

    // Get a subscription by its ID
    @GetMapping("/subscription/{subscriptionId}")
    public ResponseEntity<SubscriptionDetails> getSubscriptionDetails(@PathVariable int subscriptionId) {
        SubscriptionDetails subscriptionDetails = subscriptionDetailsService.findBySubscriptionId(subscriptionId);
        return ResponseEntity.ok(subscriptionDetails);
    }

    // Get subscriptions by status (returns a list)
    @GetMapping("/subscription/status/{subscriptionStatus}")
    public ResponseEntity<List<SubscriptionDetails>> getSubscriptionDetailsByStatus(@PathVariable String subscriptionStatus) {
        List<SubscriptionDetails> subscriptionDetailsList = subscriptionDetailsService.findBySubscriptionStatus(subscriptionStatus);
        return ResponseEntity.ok(subscriptionDetailsList);
    }

    // Get subscriptions by mode (returns a list)
    @GetMapping("/subscription/mode/{subscriptionMode}")
    public ResponseEntity<List<SubscriptionDetails>> getSubscriptionDetailsByMode(@PathVariable String subscriptionMode) {
        List<SubscriptionDetails> subscriptionDetailsList = subscriptionDetailsService.findBySubscriptionMode(subscriptionMode);
        return ResponseEntity.ok(subscriptionDetailsList);
    }

    // Update an existing subscription
    @PutMapping("/subscription/{subscriptionId}")
    public ResponseEntity<SubscriptionDetails> updateSubscriptionDetails(
            @PathVariable int subscriptionId,
            @RequestBody SubscriptionDetails updatedSubscriptionDetails) {
        SubscriptionDetails updatedSubscriptionDetails1 = subscriptionDetailsService.update(subscriptionId, updatedSubscriptionDetails);
        return ResponseEntity.ok(updatedSubscriptionDetails1);
    }

    // Delete a subscription by its ID
    @DeleteMapping("/subscription/{subscriptionId}")
    public ResponseEntity<Boolean> deleteSubscriptionDetails(@PathVariable int subscriptionId) {
        boolean isDeleted = subscriptionDetailsService.deleteBySubscriptionId(subscriptionId);
        return ResponseEntity.ok(isDeleted);
    }
}