package com.soumenprogramming.elearning.model;


import jakarta.persistence.*;

@Entity
@Table(name = "subscription_details")
public class SubscriptionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user_id")
    private int userId;

    @Column(name="course_id")
    private int courseId;

    @Column(name="subscription_id")
    private int subscriptionId;

    @Column(name="subscription_startdate")
    private String subscriptionStartDate;

    @Column(name="subscription_enddate")
    private String subscriptionEndDate;

    @Column(name="subscription_status")
    private String subscriptionStatus;

    @Column(name="subscription_amount")
    private double subscriptionAmount;

    @Column(name="subscription_mode")
    private String subscriptionMode;

    @Column(name="transaction_id")
    private String transactionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(String subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public String getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(String subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public double getSubscriptionAmount() {
        return subscriptionAmount;
    }

    public void setSubscriptionAmount(double subscriptionAmount) {
        this.subscriptionAmount = subscriptionAmount;
    }

    public String getSubscriptionMode() {
        return subscriptionMode;
    }

    public void setSubscriptionMode(String subscriptionMode) {
        this.subscriptionMode = subscriptionMode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}
