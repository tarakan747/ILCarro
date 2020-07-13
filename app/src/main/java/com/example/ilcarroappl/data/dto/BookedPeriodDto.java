package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

public class BookedPeriodDto {
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
    @SerializedName("person_who_booked")
    PersonWhoBookedDto personWhoBooked;
    @SerializedName("start_date_time")
    String startDateTime;

    public BookedPeriodDto() {
    }

    public BookedPeriodDto(Double amount, String bookingDate, String endDateTime, String orderId, Boolean paid, PersonWhoBookedDto personWhoBooked, String startDateTime) {
        this.amount = amount;
        this.bookingDate = bookingDate;
        this.endDateTime = endDateTime;
        this.orderId = orderId;
        this.paid = paid;
        this.personWhoBooked = personWhoBooked;
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

    public PersonWhoBookedDto getPersonWhoBooked() {
        return personWhoBooked;
    }

    @Override
    public String toString() {
        return "BookedPeriodDto{" +
                "amount=" + amount +
                ", bookingDate='" + bookingDate + '\'' +
                ", endDateTime='" + endDateTime + '\'' +
                ", orderId='" + orderId + '\'' +
                ", paid=" + paid +
                ", startDateTime='" + startDateTime + '\'' +
                ", personWhoBooked=" + personWhoBooked +
                '}';
    }
}
