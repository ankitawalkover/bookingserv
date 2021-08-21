package com.paypal.bfs.test.bookingser.jpa.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "app_details")
@Entity
public class BookingEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "dob", nullable = false)
    private Date dob;

    @Column(name = "checkin_datetime", nullable = false)
    private Date checkinDatetime;

    @Column(name = "checkout_datetime", nullable = false)
    private Date checkoutDatetime;

    @Column(name = "total_price", nullable = false)
    private float totalPrice;

    @Column(name = "deposit", nullable = false)
    private float deposit;

    @Column(name = "address", nullable = false)
    private AddressEntity address;

}
