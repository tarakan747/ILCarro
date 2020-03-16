package com.example.ilcarroappl.dto;

public class BookedPeriodsDto {
    Double amount_number;
    String booking_date;
    String end_date_time;
    String order_id;
    Boolean paid;
    PersonWhoBookedDto person_who_booked;
    String start_date_time;

    public BookedPeriodsDto() {
    }

    public BookedPeriodsDto(String end_date_time, String start_date_time) {
        this.end_date_time = end_date_time;
        this.start_date_time = start_date_time;
    }

    public Double getAmount_number() {
        return amount_number;
    }

    public void setAmount_number(Double amount_number) {
        this.amount_number = amount_number;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    public String getEnd_date_time() {
        return end_date_time;
    }

    public void setEnd_date_time(String end_date_time) {
        this.end_date_time = end_date_time;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public PersonWhoBookedDto getPerson_who_booked() {
        return person_who_booked;
    }

    public void setPerson_who_booked(PersonWhoBookedDto person_who_booked) {
        this.person_who_booked = person_who_booked;
    }

    public String getStart_date_time() {
        return start_date_time;
    }

    public void setStart_date_time(String start_date_time) {
        this.start_date_time = start_date_time;
    }

    @Override
    public String toString() {
        return "BookedPeriodsDto{" +
                "amount_number=" + amount_number +
                ", booking_date='" + booking_date + '\'' +
                ", end_date_time='" + end_date_time + '\'' +
                ", order_id='" + order_id + '\'' +
                ", paid=" + paid +
                ", person_who_booked=" + person_who_booked +
                ", start_date_time='" + start_date_time + '\'' +
                '}';
    }
}
