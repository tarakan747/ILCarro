package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

public class HistoryPeriodDto {
    @SerializedName("amount")
    Double amount;
    @SerializedName("booking_date")
    String bookingDate;
    @SerializedName("end_date_time")
    String endDateTime;
    @SerializedName("order_id")
    String orderId;
    @SerializedName("paid")
    Boolean paid;
    @SerializedName("start_date_time")
    String startDateTime;

    public HistoryPeriodDto() {
    }

    public HistoryPeriodDto(Double amount, String bookingDate, String endDateTime, String orderId, Boolean paid, String startDateTime) {
        this.amount = amount;
        this.bookingDate = bookingDate;
        this.endDateTime = endDateTime;
        this.orderId = orderId;
        this.paid = paid;
        this.startDateTime = startDateTime;
    }

    public Double getAmount() {
        return amount;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public Boolean getPaid() {
        return paid;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    @Override
    public String toString() {
        return "HistoryPeriodDto{" +
                "amount=" + amount +
                ", bookingDate='" + bookingDate + '\'' +
                ", endDateTime='" + endDateTime + '\'' +
                ", orderId='" + orderId + '\'' +
                ", paid=" + paid +
                ", startDateTime='" + startDateTime + '\'' +
                '}';
    }
}
