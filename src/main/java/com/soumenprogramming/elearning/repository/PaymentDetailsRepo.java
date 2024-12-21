package com.soumenprogramming.elearning.repository;

import com.soumenprogramming.elearning.model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PaymentDetailsRepo extends JpaRepository<PaymentDetails, Integer> {
    PaymentDetails findByPaymentStatus(String paymentStatus);

    PaymentDetails findByPaymentMode(String paymentMode);

    PaymentDetails findByPaymentId(int paymentId);

    PaymentDetails findByTransactionId(String transactionId);

    PaymentDetails findByUserId(int userId);

    PaymentDetails findByCourseId(int courseId);

    PaymentDetails findByPaymentDate(LocalDateTime paymentDate);
}
