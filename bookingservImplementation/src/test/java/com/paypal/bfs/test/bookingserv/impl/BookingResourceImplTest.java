package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookingResourceImplTest {

    @Autowired
    BookingResource bookingResource;

    @Test
    public void testCreateBooking() {
        Booking booking = createDummyBooking();
        bookingResource.create(booking);
    }

    private Booking createDummyBooking() {
        Booking booking = new Booking();
        return booking;
    }
}
