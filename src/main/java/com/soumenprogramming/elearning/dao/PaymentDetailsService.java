package com.soumenprogramming.elearning.dao;

import com.soumenprogramming.elearning.model.PaymentDetails;
import com.soumenprogramming.elearning.repository.PaymentDetailsRepo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDetailsService {

    @Autowired
    PaymentDetailsRepo paymentDetailsRepo;

    @Transactional
    public PaymentDetails save(PaymentDetails paymentDetails) {
        return paymentDetailsRepo.save(paymentDetails);
    }

    @Transactional(readOnly = true)
    public PaymentDetails findByPaymentId(int paymentId) {
        return paymentDetailsRepo.findByPaymentId(paymentId);
    }

    @Transactional(readOnly = true)
    public PaymentDetails findByPaymentMode(String paymentMode) {
        return paymentDetailsRepo.findByPaymentMode(paymentMode);
    }

    @Transactional(readOnly = true)
    public PaymentDetails findByPaymentStatus(String paymentStatus) {
        return paymentDetailsRepo.findByPaymentStatus(paymentStatus);
    }

    @Transactional
    public PaymentDetails update(int paymentId, PaymentDetails updatedPaymentDetails) {
        PaymentDetails existingPaymentDetails = paymentDetailsRepo.findByPaymentId(paymentId);
        if (existingPaymentDetails != null) {
            existingPaymentDetails.setPaymentStatus(updatedPaymentDetails.getPaymentStatus());
            existingPaymentDetails.setPaymentDate(updatedPaymentDetails.getPaymentDate());
            existingPaymentDetails.setPaymentMode(updatedPaymentDetails.getPaymentMode());
            return paymentDetailsRepo.save(existingPaymentDetails);
        } else {
            return null;
        }
    }

    @Transactional
    public boolean deleteByPaymentId(int paymentId) {
        PaymentDetails existingPaymentDetails = paymentDetailsRepo.findByPaymentId(paymentId);
        if (existingPaymentDetails != null) {
            paymentDetailsRepo.delete(existingPaymentDetails);
            return true;
        }
        return false;
    }



}
