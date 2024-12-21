package com.soumenprogramming.elearning.controller;

import com.soumenprogramming.elearning.dao.PaymentDetailsService;
import com.soumenprogramming.elearning.model.PaymentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentDetailsController {

    @Autowired
    private PaymentDetailsService paymentDetailsService;

    @GetMapping("/payment/{paymentId}")
    public ResponseEntity<PaymentDetails> getPaymentDetails(@PathVariable int paymentId) {
        PaymentDetails paymentDetails = paymentDetailsService.findByPaymentId(paymentId);
        return ResponseEntity.ok(paymentDetails);
    }

    @GetMapping("/payment/status/{paymentStatus}")
    public ResponseEntity<PaymentDetails> getPaymentDetailsByStatus(@PathVariable String paymentStatus) {
        PaymentDetails paymentDetails = paymentDetailsService.findByPaymentStatus(paymentStatus);
        return ResponseEntity.ok(paymentDetails);
    }

    @GetMapping("/payment/mode/{paymentMode}")
    public ResponseEntity<PaymentDetails> getPaymentDetailsByMode(@PathVariable String paymentMode) {
        PaymentDetails paymentDetails = paymentDetailsService.findByPaymentMode(paymentMode);
        return ResponseEntity.ok(paymentDetails);
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> savePaymentDetails(@RequestBody PaymentDetails paymentDetails) {
        PaymentDetails savedPaymentDetails = paymentDetailsService.save(paymentDetails);
        return ResponseEntity.ok(savedPaymentDetails);
    }

    @PutMapping("/payment/{paymentId}")
    public ResponseEntity<PaymentDetails> updatePaymentDetails(@PathVariable int paymentId, @RequestBody PaymentDetails updatedPaymentDetails) {
        PaymentDetails updatedPaymentDetails1 = paymentDetailsService.update(paymentId, updatedPaymentDetails);
        return ResponseEntity.ok(updatedPaymentDetails1);
    }

    @DeleteMapping("/payment/{paymentId}")
    public ResponseEntity<Boolean> deletePaymentDetails(@PathVariable int paymentId) {
        boolean isDeleted = paymentDetailsService.deleteByPaymentId(paymentId);
        return ResponseEntity.ok(isDeleted);
    }
}